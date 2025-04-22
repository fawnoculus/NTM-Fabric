package net.fawnoculus.ntm.main;

import net.fabricmc.api.ModInitializer;
import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.items.ModItemGroups;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.items.ModToolMaterials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NTM implements ModInitializer {
  
  public static final String MOD_ID = "ntm";
  public static final String Mod_Name = "NTM-Fabric";
  public static Logger LOGGER = LoggerFactory.getLogger(Mod_Name);
  
  @Override
  public void onInitialize() {
    LOGGER.info("Initializing NTM-Fabric");
    
    ModToolMaterials.initialize();
    ModItems.initialize();
    ModBlocks.initialize();
    ModItemGroups.initialize();
    
    
    LOGGER.info("Initialized NTM-Fabric Successfully");
  }
}
