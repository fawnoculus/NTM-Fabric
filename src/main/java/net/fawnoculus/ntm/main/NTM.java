package net.fawnoculus.ntm.main;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.commands.ModCommandArguments;
import net.fawnoculus.ntm.commands.ModCommands;
import net.fawnoculus.ntm.entity.ModDamageTypes;
import net.fawnoculus.ntm.entity.ModStatusEffects;
import net.fawnoculus.ntm.items.*;
import net.fawnoculus.ntm.network.ModPayloadHandler;
import net.fawnoculus.ntm.network.ModPayloads;
import net.fawnoculus.ntm.recipe.ModRecipes;
import net.fawnoculus.ntm.world.gen.ModWorldGeneration;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTM implements ModInitializer {
  public static final String MOD_ID = "ntm";
  public static final ModMetadata METADATA = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().getMetadata();
  public static final EnvType ENVIRONMENT = FabricLoader.getInstance().getEnvironmentType();
  public static final String MOD_NAME = METADATA.getName();
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
  
  @Override
  public void onInitialize() {
    LOGGER.info("Initializing {} ...", MOD_NAME);
    
    NTMConfig.initialize();
    
    ModDamageTypes.initialize();
    ModStatusEffects.initialize();
    
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
    
    ModPayloads.initialize();
    ModPayloadHandler.initialize();
    
    NTM.LOGGER.info("Finished {} Initialization", NTM.MOD_NAME);
  }
  
  public static Identifier id(String name){
    return Identifier.of(MOD_ID, name);
  }
}
