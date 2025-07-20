package net.fawnoculus.ntm.render.models;

import net.fawnoculus.ntm.render.ModRendering;
import net.fawnoculus.ntm.util.ClientUtil;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.regex.Pattern;

public class ModelHandler {
  private static final Pattern anyButFloats = Pattern.compile("[^.0-9\\-]+");
  
  public static void addModelToReload(Model3D model3D, @NotNull Identifier identifier) {
    ClientUtil.onResourceReload(
        (synchronizer, manager, prepareExecutor, applyExecutor) ->
            CompletableFuture.supplyAsync(() -> {
                  Optional<Resource> resource = manager.getResource(identifier);
                  if (resource.isEmpty()) {
                    ModRendering.LOGGER.warn("Could not load '{}' (.obj) File during Reload, because it does not exist", identifier);
                  } else {
                    try {
                      model3D.replaceFaces(
                          ofWavefrontObj(resource.get()).getFaces()
                      );
                    } catch (WavefrontObjSyntaxException e) {
                      ModRendering.LOGGER.warn("Exception occurred while parsing '{}' (.obj) File during Reload\nException: {}", identifier, ExceptionUtil.makePretty(e));
                    } catch (IOException e) {
                      ModRendering.LOGGER.warn("Exception occurred while trying to read '{}' (.obj) File during Reload\nException: {}", identifier, ExceptionUtil.makePretty(e));
                    }
                  }
                  return null;
                }
            )
    );
  }
  
  public static Model3D ofWavefrontObj(Identifier resourceIdentifier) {
    Model3D toBeReturned = Model3D.empty();
    Optional<Resource> resource = MinecraftClient.getInstance().getResourceManager().getResource(resourceIdentifier);
    if(resource.isEmpty()){
      ModRendering.LOGGER.warn("Could not load '{}' (.obj) File, because it does not exist", resourceIdentifier);
    }else{
      try{
        toBeReturned = ofWavefrontObj(resource.get());
      }catch (WavefrontObjSyntaxException e){
        ModRendering.LOGGER.warn("Exception occurred while parsing '{}' (.obj) File\nException: {}", resourceIdentifier, ExceptionUtil.makePretty(e));
      } catch (IOException e) {
        ModRendering.LOGGER.warn("Exception occurred while trying to read '{}' (.obj) File\nException: {}", resourceIdentifier, ExceptionUtil.makePretty(e));
      }
    }
    
    addModelToReload(toBeReturned, resourceIdentifier);
    return toBeReturned;
  }
  
  public static Model3D ofWavefrontObj(Resource resource) throws IOException, WavefrontObjSyntaxException {
    return ofWavefrontObj(new Scanner(resource.getInputStream()));
  }
  
  public static Model3D ofWavefrontObj(@NotNull Scanner scanner) throws WavefrontObjSyntaxException {
    List<GeometryVertex> geometryVertices = new ArrayList<>();
    List<TextureCoordinate> textureCoordinates = new ArrayList<>();
    List<VertexNormal> vertexNormals = new ArrayList<>();
    List<FaceIndex> faceIndices = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (line.startsWith("#")
          || line.startsWith("l")
          || line.startsWith("s")
          || line.startsWith("o")
          || line.startsWith("g")
          || line.startsWith("vp")
      ) {
        // These currently don't do anything
        continue;
      }
      
      if (line.startsWith("vt")) {
        textureCoordinates.add(getTextureCoordinate(line));
        continue;
      }
      if (line.startsWith("vn")) {
        vertexNormals.add(getVertexNormal(line));
        continue;
      }
      if (line.startsWith("v")) {
        geometryVertices.add(getGeometryVertex(line));
        continue;
      }
      if (line.startsWith("f")) {
        faceIndices.add(getFaceIndex(line));
      }
    }
    
    List<PolygonalFace> polygonalFaces = new ArrayList<>();
    for(FaceIndex faceIndex : faceIndices){
      PolygonalFace polygonalFace = faceIndex.toFace(geometryVertices, textureCoordinates, vertexNormals);
      if(polygonalFace.isInValid()){
        ModRendering.LOGGER.warn("Created Invalid Polygonal Face: {}", polygonalFace);
      }
      polygonalFaces.add(polygonalFace);
    }
    
    return new Model3D(polygonalFaces);
  }
  
  private static @NotNull TextureCoordinate getTextureCoordinate(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    stringReader.useDelimiter(anyButFloats);
    float u;
    float v = 0;
    float w = 0;
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Texture Coordinate, did not specify required value U");
    }
    u = stringReader.nextFloat();
    if (stringReader.hasNextFloat()) {
      v = stringReader.nextFloat();
    }
    if (stringReader.hasNextFloat()) {
      w = stringReader.nextFloat();
    }
    return new TextureCoordinate(u, v, w);
  }
  public static @NotNull VertexNormal getVertexNormal(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    stringReader.useDelimiter(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Vertex Normal, did not specify required value X");
    }
    float u = stringReader.nextFloat();
    
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Vertex Normal, did not specify required value Y");
    }
    float v = stringReader.nextFloat();
    
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Vertex Normal, did not specify required value Z");
    }
    float w = stringReader.nextFloat();
    
    return new VertexNormal(u, v, w);
  }
  public static @NotNull GeometryVertex getGeometryVertex(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    stringReader.useDelimiter(anyButFloats);
    float x;
    float y;
    float z;
    Float w = null;
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Geometry Vertex, did not specify required value X");
    }
    x = stringReader.nextFloat();
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Geometry Vertex, did not specify required value y");
    }
    y = stringReader.nextFloat();
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Geometry Vertex, did not specify required value z");
    }
    z = stringReader.nextFloat();
    if (stringReader.hasNextFloat()) {
      w = stringReader.nextFloat();
    }
    return new GeometryVertex(x, y, z, w);
  }
  private static final Collection<Character> digits = List.of('-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
  public static @NotNull FaceIndex getFaceIndex(String line) {
    // After 5 hours of the Scanner with a Delimiter not cooperating, I have decided to do whatever this shit is
    // it is bad & I know it
    // am I going to fix it?
    // absolutely not, I will not spend even more time ting to fix this
    Stack<Character> stack = new Stack<>();
    for(Character c : new StringBuilder(line).reverse().toString().toCharArray()){
      stack.push(c);
    }
    
    List<Integer> vertexIndices = new ArrayList<>();
    List<Integer> coordinateIndices = new ArrayList<>();
    List<Integer> normalIndices = new ArrayList<>();
    
    while (!stack.isEmpty()){
      switch (stack.peek()){
        case '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> handleIndices(stack, vertexIndices, coordinateIndices, normalIndices);
        case '/' -> throw new WavefrontObjSyntaxException("Malformed Vertex Index, did not specify Index before Separator");
        default -> stack.pop();
      }
    }
    
    return new FaceIndex(vertexIndices, coordinateIndices, normalIndices);
  }
  private static void handleIndices(Stack<Character> stack, List<Integer> vertexIndices, List<Integer> coordinateIndices, List<Integer> normalIndices){
    Integer vertex;
    Integer coordinate = null;
    Integer normal = null;
    
    vertex = makeNum(stack);
    while (!stack.isEmpty() && !(digits.contains(stack.peek()) || stack.peek() == '/')) stack.pop();
    if(!stack.isEmpty() && stack.peek() == '/'){
      stack.pop();
      if(!stack.isEmpty() && digits.contains(stack.peek())){
        coordinate = makeNum(stack);
      }
      while (!stack.isEmpty() && !(digits.contains(stack.peek()) || stack.peek() == '/')) stack.pop();
      if(!stack.isEmpty() && stack.peek() == '/'){
        stack.pop();
        if(!stack.isEmpty() && digits.contains(stack.peek())){
          normal = makeNum(stack);
        }
      }
    }
    
    vertexIndices.add(vertex);
    coordinateIndices.add(coordinate);
    normalIndices.add(normal);
  }
  
  private static Integer makeNum(Stack<Character> stack){
    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty() && digits.contains(stack.peek())){
      builder.append(stack.pop());
    }
    return Integer.parseInt(builder.toString()) - 1;
  }
}
