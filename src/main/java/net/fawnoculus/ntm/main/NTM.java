package net.fawnoculus.ntm.main;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.commands.ModCommandArguments;
import net.fawnoculus.ntm.commands.ModCommands;
import net.fawnoculus.ntm.items.*;
import net.fawnoculus.ntm.recipe.AlloyFurnaceRecipe;
import net.fawnoculus.ntm.recipe.ModRecipes;
import net.fawnoculus.ntm.world.gen.ModWorldGeneration;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

public class NTM implements ModInitializer {
  
  public static final String MOD_ID = "ntm";
  public static final ModMetadata METADATA = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata();
  public static final EnvType ENVIRONMENT = FabricLoader.getInstance().getEnvironmentType();
  public static final Path CONFIG_DIR = FabricLoader.getInstance().getConfigDir();
  public static final String MOD_NAME = METADATA.getName();
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
  
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
    
    ModRecipes.initialize();
    
    ModCommandArguments.initialize();
    ModCommands.initialize();
    
    ModWorldGeneration.initialize();
    
    LOGGER.info("Initialization finished");
  }
  
  public static Identifier id(String name){
    return Identifier.of(MOD_ID, name);
  }
}
