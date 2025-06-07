package net.fawnoculus.ntm.main;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.commands.ModCommands;
import net.fawnoculus.ntm.items.*;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTM implements ModInitializer {
  
  public static final String MOD_ID = "ntm";
  public static final String Mod_Name = "NTM-Fabric";
  public static final ModMetadata METADATA = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata();
  public static final Logger LOGGER = LoggerFactory.getLogger(Mod_Name);
  public static final EnvType ENVIRONMENT = FabricLoader.getInstance().getEnvironmentType();
  
  @Override
  public void onInitialize() {
    LOGGER.info("Initializing NTM-Fabric ...");
    
    NTMConfig.initialize();
    
    ModToolMaterials.initialize();
    ModDataComponentTypes.initialize();
    ModItems.initialize();
    ModItemGroups.initialize();
    ModEnchantmentEffects.initialize();
    
    ModBlocks.initialize();
    ModBlockEntities.initialize();
    
    ModCommands.initialize();
    
    LOGGER.info("NTM-Fabric is now initialized");
  }
  
  public static Identifier id(String name){
    return Identifier.of(MOD_ID, name);
  }
}
