package net.fawnoculus.ntm.datagen.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.util.tags.ModItemTags;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends FabricTagProvider<Item> {
  public ItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, RegistryKeys.ITEM, registriesFuture);
  }
  
  @Override
  protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
    // Tool Materials
    getOrCreateTagBuilder(ModItemTags.STEEL_TOOL_MATERIALS)
        .add(ModItems.STEEL_INGOT)
        .setReplace(false);
    
    // Ore Items
  }
  
  
  @Override
  public String getName() {
    return NTM.MOD_ID + " Item-Tag Provider";
  }
}
