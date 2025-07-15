package net.fawnoculus.ntm.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Predicate;

public class EnchantmentUtil {
  private static final Registry<Enchantment> registry = DynamicRegistryManager.of(Registries.REGISTRIES).getOrThrow(RegistryKeys.ENCHANTMENT);
  
  public static boolean hasEnchantment( ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey){
    return EnchantmentHelper.getLevel(getEnchantmentEntry(enchantmentRegistryKey), stack) > 0;
  }
  
  public static void addEnchantment(@NotNull ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey, int level){
    RegistryEntry<Enchantment> enchantmentRegistryEntry = getEnchantmentEntry(enchantmentRegistryKey);
    stack.addEnchantment(enchantmentRegistryEntry, level);
  }
  
  public static void removeEnchantment(@NotNull ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey){
    RegistryEntry<Enchantment> enchantment = getEnchantmentEntry(enchantmentRegistryKey);
    
    ItemEnchantmentsComponent itemEnchantmentsComponent = stack.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);
    ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(itemEnchantmentsComponent);
    builder.remove(Predicate.isEqual(enchantment));
    
    stack.set(DataComponentTypes.ENCHANTMENTS, builder.build());
  }
  
  public static @Nullable RegistryEntry<Enchantment> getEnchantmentEntry(@NotNull RegistryKey<Enchantment> enchantmentRegistryKey){
    Enchantment enchantment = registry.get(enchantmentRegistryKey);
    
    return registry.getEntry(enchantment);
  }
}
