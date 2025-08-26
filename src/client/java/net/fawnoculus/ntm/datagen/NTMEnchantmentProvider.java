package net.fawnoculus.ntm.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceCondition;
import net.fawnoculus.ntm.NTM;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class NTMEnchantmentProvider extends FabricDynamicRegistryProvider {
  public NTMEnchantmentProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
    super(output, registriesFuture);
  }

  @Override
  protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
    RegistryWrapper<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

    /*
    register(entries, NTMEnchantmentEffects.THUNDERING_KEY, Enchantment.builder(
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
