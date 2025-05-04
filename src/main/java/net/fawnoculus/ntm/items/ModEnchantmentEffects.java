package net.fawnoculus.ntm.items;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.items.enchantments.LightningEnchantmentEffect;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
  private static RegistryKey<Enchantment> of(String path) {
    return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(NTM.MOD_ID, path));
  }
  
  private static <T extends EnchantmentEntityEffect> MapCodec<T> register(String id, MapCodec<T> codec) {
    return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(NTM.MOD_ID, id), codec);
  }
  
  public static final RegistryKey<Enchantment> THUNDERING_KEY = of("thundering");
  public static MapCodec<LightningEnchantmentEffect> LIGHTNING_EFFECT = register("lightning_effect", LightningEnchantmentEffect.CODEC);
  
  public static void initialize() {}
}
