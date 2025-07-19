package net.fawnoculus.ntm.render.models;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.minecraft.client.MinecraftClient;
import net.minecraft.resource.Resource;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ModelHelper {
  private static final Pattern anyButFloats = Pattern.compile("[^0-9.]+");
  private static final Pattern anyButIndexes = Pattern.compile("[^0-9/]+");
  
  public static Model3D ofWavefront(Identifier resourceIdentifier) {
    try{
      Optional<Resource> resource = MinecraftClient.getInstance().getResourceManager().getResource(resourceIdentifier);
      if(resource.isEmpty()){
        NTM.LOGGER.warn("Could not load '{}' (.obj) File, because it does not exist", resourceIdentifier);
        return Model3D.empty();
      }
      return ofWavefront(new Scanner(resource.get().getInputStream()));
    }catch (WavefrontObjSyntaxException e){
      NTM.LOGGER.warn("Exception occurred while parsing '{}' (.obj) File\nException: {}", resourceIdentifier, ExceptionUtil.makePretty(e));
    } catch (IOException e) {
      NTM.LOGGER.warn("Exception occurred while trying to read '{}' (.obj) File\nException: {}", resourceIdentifier, ExceptionUtil.makePretty(e));
    }
    return Model3D.empty();
  }
  
  public static Model3D ofWavefront(@NotNull Scanner scanner) throws WavefrontObjSyntaxException {
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
      if(!polygonalFace.isValid()) throw new IllegalStateException("Created Invalid PolygonalFace");
      polygonalFaces.add(polygonalFace);
    }
    
    return new Model3D(polygonalFaces);
  }
  
  private static @NotNull TextureCoordinate getTextureCoordinate(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    float u;
    float v = 0;
    float w = 0;
    stringReader.skip(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Texture Coordinate, did not specify required value U");
    }
    u = stringReader.nextFloat();
    stringReader.skip(anyButFloats);
    if (stringReader.hasNextFloat()) {
      v = stringReader.nextFloat();
    }
    stringReader.skip(anyButFloats);
    if (stringReader.hasNextFloat()) {
      w = stringReader.nextFloat();
    }
    return new TextureCoordinate(u, v, w);
  }
  private static @NotNull VertexNormal getVertexNormal(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    stringReader.skip(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Vertex Normal, did not specify required value X");
    }
    float u = stringReader.nextFloat();
    
    stringReader.skip(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Vertex Normal, did not specify required value Y");
    }
    float v = stringReader.nextFloat();
    
    stringReader.skip(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Vertex Normal, did not specify required value Z");
    }
    float w = stringReader.nextFloat();
    
    return new VertexNormal(u, v, w);
  }
  private static @NotNull GeometryVertex getGeometryVertex(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    float x;
    float y;
    float z;
    Float w = null;
    stringReader.skip(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Geometry Vertex, did not specify required value X");
    }
    x = stringReader.nextFloat();
    stringReader.skip(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Geometry Vertex, did not specify required value y");
    }
    y = stringReader.nextFloat();
    stringReader.skip(anyButFloats);
    if (!stringReader.hasNextFloat()) {
      throw new WavefrontObjSyntaxException("Malformed Geometry Vertex, did not specify required value z");
    }
    z = stringReader.nextFloat();
    stringReader.skip(anyButFloats);
    if (stringReader.hasNextFloat()) {
      w = stringReader.nextFloat();
    }
    return new GeometryVertex(x, y, z, w);
  }
  private static @NotNull FaceIndex getFaceIndex(String line) {
    Scanner stringReader = new Scanner(new StringReader(line));
    List<Integer> vertexIndices = new ArrayList<>();
    List<Integer> coordinateIndices = new ArrayList<>();
    List<Integer> normalIndices = new ArrayList<>();
    stringReader.skip(anyButIndexes);
    while (stringReader.hasNextInt()){
      vertexIndices.add(stringReader.nextInt());
      stringReader.skip("/");
      if(stringReader.hasNextInt()){
        coordinateIndices.add(stringReader.nextInt());
      }
      stringReader.skip("/");
      if(stringReader.hasNextInt()){
        normalIndices.add(stringReader.nextInt());
      }
      stringReader.skip(anyButIndexes);
    }
    FaceIndex faceIndex = new FaceIndex();
    faceIndex.addIndexes(vertexIndices, coordinateIndices, normalIndices);
    return faceIndex;
  }
}
