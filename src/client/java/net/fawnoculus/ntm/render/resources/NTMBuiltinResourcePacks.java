package net.fawnoculus.ntm.render.resources;

import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMClient;
import net.minecraft.text.Text;

public class NTMBuiltinResourcePacks {
  public static void initialize(){
    if(!ResourceManagerHelper.registerBuiltinResourcePack(NTM.id("legacy_names"), NTM.MOD_CONTAINER, Text.translatable("resourcePack.ntm_legacy_names.name"), ResourcePackActivationType.NORMAL)){
      NTMClient.LOGGER.warn("Failed to load 'Legacy Names' Resource Pack");
    }
    if(!ResourceManagerHelper.registerBuiltinResourcePack(NTM.id("legacy_textures"), NTM.MOD_CONTAINER, Text.translatable("resourcePack.ntm_legacy_textures.name"), ResourcePackActivationType.NORMAL)){
      NTMClient.LOGGER.warn("Failed to load 'Legacy Textures' Resource Pack");
    }
  }
}
