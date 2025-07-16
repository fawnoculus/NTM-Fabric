package net.fawnoculus.ntm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.commands.ModCommandArguments;
import net.fawnoculus.ntm.commands.ModCommands;
import net.fawnoculus.ntm.entity.ModDamageTypes;
import net.fawnoculus.ntm.entity.ModStatusEffects;
import net.fawnoculus.ntm.fluid.ModFluids;
import net.fawnoculus.ntm.items.*;
import net.fawnoculus.ntm.network.ModServerPayloadHandler;
import net.fawnoculus.ntm.network.ModPayloads;
import net.fawnoculus.ntm.recipe.ModRecipes;
import net.fawnoculus.ntm.misc.ModSounds;
import net.fawnoculus.ntm.misc.ModParticles;
import net.fawnoculus.ntm.world.gen.ModWorldGeneration;
import net.fawnoculus.ntm.misc.radiation.RadiationManager;
import net.fawnoculus.ntm.misc.radiation.RadiationRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTM implements ModInitializer {
  public static final String MOD_ID = "ntm";
  public static final ModMetadata METADATA = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().getMetadata();
  public static final String MOD_NAME = METADATA.getName();
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
  
  @Override
  public void onInitialize() {
    LOGGER.info("Initializing {} ...", NTM.MOD_NAME);
    
    NTMConfig.initialize();
    
    ModDamageTypes.initialize();
    ModStatusEffects.initialize();
    
    ModSounds.initialize();
    ModParticles.initialize();
    
    ModToolMaterials.initialize();
    ModDataComponentTypes.initialize();
    ModItems.initialize();
    ModItemGroups.initialize();
    ExtraItemData.initialize();
    ModEnchantmentEffects.initialize();
    
    ModFluids.initialize();
    
    ModBlocks.initialize();
    ModBlockEntities.initialize();
    
    RadiationManager.initialize();
    RadiationRegistry.initialize();
    
    ModRecipes.initialize();
    
    ModCommandArguments.initialize();
    ModCommands.initialize();
    
    ModWorldGeneration.initialize();
    
    ModPayloads.initialize();
    ModServerPayloadHandler.initialize();
    
    NTM.LOGGER.info("Finished {} Initialization", NTM.MOD_NAME);
  }
  
  public static Identifier id(String name){
    return Identifier.of(MOD_ID, name);
  }
}
