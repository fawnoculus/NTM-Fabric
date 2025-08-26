package net.fawnoculus.ntm.render.wavefront;

import net.fawnoculus.ntm.NTMClient;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

public class ModelHandler {
  private static final Pattern anyButFloats = Pattern.compile("[^.0-9\\-]+");

  public static MultiModel3D ofWavefrontObj(Identifier resourceIdentifier) {
    MultiModel3D toBeReturned = new MultiModel3D();
    Optional<Resource> resource = MinecraftClient.getInstance().getResourceManager().getResource(resourceIdentifier);
    if (resource.isEmpty()) {
      NTMClient.LOGGER.warn("Could not load '{}' (.obj) File, because it does not exist", resourceIdentifier);
    } else {
      try {
        toBeReturned = ofWavefrontObj(new Scanner(resource.get().getInputStream()), resourceIdentifier.toString());
      } catch (WavefrontSyntaxException e) {
        NTMClient.LOGGER.warn("Exception occurred while parsing '{}' (.obj) File\nException: {}", resourceIdentifier, ExceptionUtil.makePretty(e));
      } catch (IOException e) {
        NTMClient.LOGGER.warn("Exception occurred while trying to read '{}' (.obj) File\nException: {}", resourceIdentifier, ExceptionUtil.makePretty(e));
      }
    }

    return toBeReturned;
  }

  public static MultiModel3D ofWavefrontObj(@NotNull Scanner scanner, String name) throws WavefrontSyntaxException {
    List<GeometryVertex> geometryVertices = new ArrayList<>();
    List<TextureCoordinate> textureCoordinates = new ArrayList<>();
    List<VertexNormal> vertexNormals = new ArrayList<>();
    List<FaceIndex> faceIndices = new ArrayList<>();
    HashMap<String, HashMap<String, List<FaceIndex>>> groupedFaces = new HashMap<>();
    String object = "";
    String group = "";

    groupedFaces.put(object, new HashMap<>());
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      if (line.startsWith("#")
        || line.startsWith("l")
        || line.startsWith("s")
        || line.startsWith("vp")
      ) {
        continue;
      }
      if (line.startsWith("o ")) {
        groupedFaces.get(object).put(group, faceIndices);
        object = line.substring(2);
        groupedFaces.put(object, new HashMap<>());
        faceIndices = new ArrayList<>();
      }
      if (line.startsWith("g ")) {
        groupedFaces.get(object).put(group, faceIndices);
        group = line.substring(2);
        faceIndices = new ArrayList<>();
      }
      if (line.startsWith("v ")) {
        geometryVertices.add(getGeometryVertex(line));
        continue;
      }
      if (line.startsWith("vt ")) {
        textureCoordinates.add(getTextureCoordinate(line));
        continue;
      }
      if (line.startsWith("vn ")) {
        vertexNormals.add(getVertexNormal(line));
        continue;
      }
      if (line.startsWith("f ")) {
        faceIndices.add(getFaceIndex(line));
      }
    }
    groupedFaces.get(object).put(group, faceIndices);

    MultiModel3D multiModel = new MultiModel3D(name);
    for (String objectName : groupedFaces.keySet()) {
      for (String groupName : groupedFaces.get(objectName).keySet()) {
        List<PolygonalFace> polygonalFaces = new ArrayList<>();
        for (FaceIndex faceIndex : groupedFaces.get(objectName).get(groupName)) {
          PolygonalFace polygonalFace = faceIndex.toFace(geometryVertices, textureCoordinates, vertexNormals);
          if (polygonalFace.isInValid()) {
            NTMClient.LOGGER.warn("Created Invalid Polygonal Face: {}", polygonalFace);
          }
          polygonalFaces.add(polygonalFace);
        }
        multiModel.addModel(objectName, groupName, new Model3D(polygonalFaces));
      }
    }

    return multiModel;
  }

  private static @NotNull TextureCoordinate getTextureCoordinate(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    stringReader.useDelimiter(anyButFloats);
    float u;
    float v = 0;
    float w = 0;
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontSyntaxException("Malformed Texture Coordinate, did not specify required value U");
    }
    u = stringReader.nextFloat();
    if (stringReader.hasNextFloat()) {
      v = stringReader.nextFloat();
    }
    return new TextureCoordinate(u, v);
  }

  public static @NotNull VertexNormal getVertexNormal(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    stringReader.useDelimiter(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontSyntaxException("Malformed Vertex Normal, did not specify required value X");
    }
    float u = stringReader.nextFloat();

    if (!stringReader.hasNextFloat()) {
      throw new WavefrontSyntaxException("Malformed Vertex Normal, did not specify required value Y");
    }
    float v = stringReader.nextFloat();

    if (!stringReader.hasNextFloat()) {
      throw new WavefrontSyntaxException("Malformed Vertex Normal, did not specify required value Z");
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
      throw new WavefrontSyntaxException("Malformed Geometry Vertex, did not specify required value X");
    }
    x = stringReader.nextFloat();
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontSyntaxException("Malformed Geometry Vertex, did not specify required value y");
    }
    y = stringReader.nextFloat();
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontSyntaxException("Malformed Geometry Vertex, did not specify required value z");
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
    for (Character c : new StringBuilder(line).reverse().toString().toCharArray()) {
      stack.push(c);
    }

    List<Integer> vertexIndices = new ArrayList<>();
    List<Integer> coordinateIndices = new ArrayList<>();
    List<Integer> normalIndices = new ArrayList<>();

    while (!stack.isEmpty()) {
      switch (stack.peek()) {
        case '-', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' ->
          handleIndices(stack, vertexIndices, coordinateIndices, normalIndices);
        case '/' ->
          throw new WavefrontSyntaxException("Malformed Vertex Index, did not specify Index before Separator");
        default -> stack.pop();
      }
    }

    return new FaceIndex(vertexIndices, coordinateIndices, normalIndices);
  }

  private static void handleIndices(Stack<Character> stack, List<Integer> vertexIndices, List<Integer> coordinateIndices, List<Integer> normalIndices) {
    Integer vertex;
    Integer coordinate = null;
    Integer normal = null;

    vertex = makeNum(stack);
    while (!stack.isEmpty() && !(digits.contains(stack.peek()) || stack.peek() == '/')) stack.pop();
    if (!stack.isEmpty() && stack.peek() == '/') {
      stack.pop();
      if (!stack.isEmpty() && digits.contains(stack.peek())) {
        coordinate = makeNum(stack);
      }
      while (!stack.isEmpty() && !(digits.contains(stack.peek()) || stack.peek() == '/')) stack.pop();
      if (!stack.isEmpty() && stack.peek() == '/') {
        stack.pop();
        if (!stack.isEmpty() && digits.contains(stack.peek())) {
          normal = makeNum(stack);
        }
      }
    }

    vertexIndices.add(vertex);
    coordinateIndices.add(coordinate);
    normalIndices.add(normal);
  }

  private static Integer makeNum(Stack<Character> stack) {
    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty() && digits.contains(stack.peek())) {
      builder.append(stack.pop());
    }
    return Integer.parseInt(builder.toString()) - 1;
  }
}
