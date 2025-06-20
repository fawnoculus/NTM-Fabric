package net.fawnoculus.ntm.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;

public class EnchantmentUtil {
  public static boolean hasEnchantment( ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey){
    RegistryEntry<Enchantment> enchantmentRegistryEntry = getEnchantmentEntry(enchantmentRegistryKey);
    return net.minecraft.enchantment.EnchantmentHelper.getLevel(enchantmentRegistryEntry, stack) > 0;
  }
  
  public static void addEnchantment(ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey, int level){
    RegistryEntry<Enchantment> enchantmentRegistryEntry = getEnchantmentEntry(enchantmentRegistryKey);
    stack.addEnchantment(enchantmentRegistryEntry, level);
  }
  
  public static void removeEnchantment(ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey){
    // TODO: this
  }
  
  public static RegistryEntry<Enchantment> getEnchantmentEntry(RegistryKey<Enchantment> enchantmentRegistryKey){
    // TODO: this
    return null;
  }
}
