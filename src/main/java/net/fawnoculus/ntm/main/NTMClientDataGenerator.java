package net.fawnoculus.ntm.main;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fawnoculus.ntm.datagen.ModelProvider;

public class NTMClientDataGenerator implements DataGeneratorEntrypoint {
  
  @Override
  public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
    FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
    
    pack.addProvider(ModelProvider::new);
    
  }
}
