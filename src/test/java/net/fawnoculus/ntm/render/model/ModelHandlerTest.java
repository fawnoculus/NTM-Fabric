package net.fawnoculus.ntm.render.model;

import net.fawnoculus.ntm.render.model3d.FaceIndex;
import net.fawnoculus.ntm.render.model3d.ModelHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ModelHandlerTest {
  
  @Test
  void testGetFaceIndex(){
    FaceIndex faceIndex1 = ModelHandler.getFaceIndex("f 1/1/1 2/2/2 3/3/3");
    
    for (int i = 0; i < 3; i++) {
      Assertions.assertEquals(faceIndex1.vertexIndexes.get(i), i);
      Assertions.assertEquals(faceIndex1.coordinateIndexes.get(i), i );
      Assertions.assertEquals(faceIndex1.normalIndexes.get(i), i);
    }
    
    FaceIndex faceIndex2 = ModelHandler.getFaceIndex("f 1 2 3");
    
    for (int i = 0; i < 3; i++) {
      Assertions.assertEquals(faceIndex2.vertexIndexes.get(i), i);
      Assertions.assertNull(faceIndex2.coordinateIndexes.get(i));
      Assertions.assertNull(faceIndex2.normalIndexes.get(i));
    }
    
    FaceIndex faceIndex3 = ModelHandler.getFaceIndex("f 1//1 2//2 3//3");
    
    for (int i = 0; i < 3; i++) {
      Assertions.assertEquals(faceIndex3.vertexIndexes.get(i), i);
      Assertions.assertNull(faceIndex3.coordinateIndexes.get(i));
      Assertions.assertEquals(faceIndex3.normalIndexes.get(i), i);
    }
  }
}
