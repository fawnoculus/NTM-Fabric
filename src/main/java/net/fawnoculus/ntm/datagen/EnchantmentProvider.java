package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fawnoculus.ntm.items.ModEnchantmentEffects;
import net.fawnoculus.ntm.items.enchantments.LightningEnchantmentEffect;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class EnchantmentProvider extends FabricDynamicRegistryProvider {
  public EnchantmentProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }
  @Override
  protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
    RegistryWrapper<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
    
    /*
    register(entries, ModEnchantmentEffects.THUNDERING_KEY, Enchantment.builder(
        Enchantment.definition(
            itemLookup.getOrThrow(ItemTags.WEAPON_ENCHANTABLE),
            10,
            3,
            Enchantment.leveledCost(1, 10),
            Enchantment.leveledCost(1, 15),
            5,
            AttributeModifierSlot.HAND
        )
    ).addEffect(
        EnchantmentEffectComponentTypes.POST_ATTACK,
        EnchantmentEffectTarget.ATTACKER,
        EnchantmentEffectTarget.VICTIM,
        new LightningEnchantmentEffect(EnchantmentLevelBasedValue.linear(0.4f, 0.2f))
    ));
     */
  }
  private void register(Entries entries, RegistryKey<Enchantment> key, Enchantment.Builder builder, ResourceCondition... resourceConditions) {
    entries.add(key, builder.build(key.getValue()), resourceConditions);
  }
  @Override
  public String getName() {
    return NTM.MOD_NAME + " Enchantment Provider";
  }
  
}
