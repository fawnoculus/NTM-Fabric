package net.fawnoculus.ntm;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.Version;
import net.fabricmc.loader.api.metadata.ModMetadata;
import net.fawnoculus.ntm.blocks.ExtraBlockData;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.commands.NTMCommandArguments;
import net.fawnoculus.ntm.commands.NTMCommands;
import net.fawnoculus.ntm.entity.NTMDamageTypes;
import net.fawnoculus.ntm.entity.NTMStatusEffects;
import net.fawnoculus.ntm.fluid.NTMFluids;
import net.fawnoculus.ntm.items.*;
import net.fawnoculus.ntm.misc.radiation.HazmatRegistry;
import net.fawnoculus.ntm.network.NTMServerPayloadHandler;
import net.fawnoculus.ntm.network.NTMPayloads;
import net.fawnoculus.ntm.recipe.NTMRecipes;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.fawnoculus.ntm.misc.NTMParticles;
import net.fawnoculus.ntm.world.gen.NTMWorldGeneration;
import net.fawnoculus.ntm.misc.radiation.RadiationManager;
import net.fawnoculus.ntm.misc.radiation.RadiationRegistry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTM implements ModInitializer {
  public static final String MOD_ID = "ntm";
  public static final ModMetadata METADATA = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow().getMetadata();
  public static final String MOD_NAME = METADATA.getName();
  public static final Version MOD_VERSION = METADATA.getVersion();
  public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);
  
  @Override
  public void onInitialize() {
    LOGGER.info("Initializing {} ...", NTM.MOD_NAME);
    
    NTMConfig.initialize();
    
    NTMDamageTypes.initialize();
    NTMStatusEffects.initialize();
    
    NTMSounds.initialize();
    NTMParticles.initialize();
    
    NTMToolMaterials.initialize();
    NTMDataComponentTypes.initialize();
    NTMItems.initialize();
    NTMItemGroups.initialize();
    ExtraItemData.initialize();
    NTMEnchantmentEffects.initialize();
    
    NTMFluids.initialize();
    
    NTMBlocks.initialize();
    NTMBlockEntities.initialize();
    ExtraBlockData.initialize();
    
    RadiationManager.initialize();
    RadiationRegistry.initialize();
    HazmatRegistry.initialize();
    
    NTMRecipes.initialize();
    
    NTMCommandArguments.initialize();
    NTMCommands.initialize();
    
    NTMWorldGeneration.initialize();
    
    NTMPayloads.initialize();
    NTMServerPayloadHandler.initialize();
    
    NTM.LOGGER.info("Finished {} Initialization", NTM.MOD_NAME);
  }
  
  public static Identifier id(String name){
    return Identifier.of(MOD_ID, name);
  }
}
