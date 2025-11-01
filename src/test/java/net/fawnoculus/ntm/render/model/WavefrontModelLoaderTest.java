package net.fawnoculus.ntm.render.model;

import net.fawnoculus.ntm.render.wavefront.Polygon;
import net.fawnoculus.ntm.render.wavefront.WavefrontModelLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WavefrontModelLoaderTest {

  @Test
  void testFloatParser(){
    float[] floats1 = WavefrontModelLoader.parseFloats(3, "1 2 3", 0);
    Assertions.assertEquals(3, floats1.length);
    Assertions.assertEquals(1, floats1[0]);
    Assertions.assertEquals(2, floats1[1]);
    Assertions.assertEquals(3, floats1[2]);

    float[] floats2 = WavefrontModelLoader.parseFloats(2, "abc 1 2", 3);
    Assertions.assertEquals(2, floats2.length);
    Assertions.assertEquals(1, floats2[0]);
    Assertions.assertEquals(2, floats2[1]);
  }

  @Test
  void testFaceIndexParser(){
    int[] ints1 = WavefrontModelLoader.parseFaceIndices("2/5/8".toCharArray(), 0, 5);
    Assertions.assertEquals(3, ints1.length);
    Assertions.assertEquals(2, ints1[0]);
    Assertions.assertEquals(5, ints1[1]);
    Assertions.assertEquals(8, ints1[2]);

    int[] ints2 = WavefrontModelLoader.parseFaceIndices("1//6".toCharArray(), 0, 4);
    Assertions.assertEquals(3, ints2.length);
    Assertions.assertEquals(1, ints2[0]);
    Assertions.assertEquals(0, ints2[1]);
    Assertions.assertEquals(6, ints2[2]);

    int[] ints3 = WavefrontModelLoader.parseFaceIndices("1".toCharArray(), 0, 1);
    Assertions.assertEquals(3, ints3.length);
    Assertions.assertEquals(1, ints3[0]);
    Assertions.assertEquals(0, ints3[1]);
    Assertions.assertEquals(0, ints3[2]);

    int[] ints4 = WavefrontModelLoader.parseFaceIndices("garbage 8 garbage".toCharArray(), 8, 9);
    Assertions.assertEquals(3, ints4.length);
    Assertions.assertEquals(8, ints4[0]);
    Assertions.assertEquals(0, ints4[1]);
    Assertions.assertEquals(0, ints4[2]);
  }

  @Test
  void testGetFaceIndex(){
    Polygon.Indexed faceIndex1 = WavefrontModelLoader.getFaceIndex("f 0/0/0 1/1/1 2/2/2");
    for (int i = 0; i < 3; i++) {
      Assertions.assertEquals(i, faceIndex1.vertexIndexes()[i]);
      Assertions.assertEquals(i, faceIndex1.coordinateIndexes()[i]);
      Assertions.assertEquals(i, faceIndex1.normalIndexes()[i]);
    }

    Polygon.Indexed faceIndex2 = WavefrontModelLoader.getFaceIndex("f 0 1 2");
    for (int i = 0; i < 3; i++) {
      Assertions.assertEquals(i, faceIndex2.vertexIndexes()[i]);
      Assertions.assertEquals(0, faceIndex2.coordinateIndexes()[i]);
      Assertions.assertEquals(0, faceIndex2.normalIndexes()[i]);
    }

    Polygon.Indexed faceIndex3 = WavefrontModelLoader.getFaceIndex("f 0//0 1//1 2//2");
    for (int i = 0; i < 3; i++) {
      Assertions.assertEquals(i, faceIndex3.vertexIndexes()[i]);
      Assertions.assertEquals(0, faceIndex3.coordinateIndexes()[i]);
      Assertions.assertEquals(i, faceIndex3.normalIndexes()[i]);
    }
  }
}
