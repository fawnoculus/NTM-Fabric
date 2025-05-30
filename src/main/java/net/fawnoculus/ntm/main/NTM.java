package net.fawnoculus.ntm.main;

import net.fabricmc.api.ModInitializer;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.*;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTM implements ModInitializer {
  
  public static final String MOD_ID = "ntm";
  public static final String Mod_Name = "NTM-Fabric";
  public static final Logger LOGGER = LoggerFactory.getLogger(Mod_Name);
  
  @Override
  public void onInitialize() {
    LOGGER.info("Initializing NTM-Fabric ...");
    
    ModToolMaterials.initialize();
    ModItems.initialize();
    ModItemGroups.initialize();
    ModDataComponentTypes.initialize();
    ModEnchantmentEffects.initialize();
    
    ModBlocks.initialize();
    ModBlockEntities.initialize();
    
    NTMConfig.initialize();
    LOGGER.warn("VALUE: {}", NTMConfig.test.getValue());
    LOGGER.warn("LIST_VALUE: {}", NTMConfig.testList.getValue());
    
    LOGGER.warn("TestInt: {}", NTMConfig.testInt.getValue());
    
    LOGGER.info("NTM-Fabric is now initialized");
  }
  
  public static Identifier id(String name){
    return Identifier.of(MOD_ID, name);
  }
}
