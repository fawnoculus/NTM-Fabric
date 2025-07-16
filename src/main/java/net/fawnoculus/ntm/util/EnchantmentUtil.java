package net.fawnoculus.ntm.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.Predicate;

public class EnchantmentUtil {
  //TODO: fix whatever is wrong with this
  
  public static boolean hasEnchantment(@NotNull World world, RegistryKey<Enchantment> enchantmentKey, ItemStack stack){
    return EnchantmentHelper.getLevel(getEnchantmentEntry(world, enchantmentKey), stack) > 0;
  }
  
  public static void addEnchantment(@NotNull World world, RegistryKey<Enchantment> enchantmentKey, int level ,@NotNull ItemStack stack){
    RegistryEntry<Enchantment> enchantmentRegistryEntry = getEnchantmentEntry(world, enchantmentKey);
    stack.addEnchantment(enchantmentRegistryEntry, level);
  }
  
  public static void removeEnchantment(@NotNull World world, RegistryKey<Enchantment> enchantmentKey, @NotNull ItemStack stack){
    ItemEnchantmentsComponent itemEnchantmentsComponent = stack.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);
    ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(itemEnchantmentsComponent);
    builder.remove(Predicate.isEqual(getEnchantmentEntry(world, enchantmentKey)));
    
    stack.set(DataComponentTypes.ENCHANTMENTS, builder.build());
  }
  
  public static @NotNull RegistryEntry<Enchantment> getEnchantmentEntry(@NotNull World world, @NotNull RegistryKey<Enchantment> enchantmentKey){
    Enchantment enchantment = world.getRegistryManager()
        .getOrThrow(RegistryKeys.ENCHANTMENT)
        .get(enchantmentKey);
    if(enchantment == null){
      Optional<RegistryEntry.Reference<Enchantment>> optional = world.getRegistryManager()
              .getOrThrow(RegistryKeys.ENCHANTMENT)
              .getDefaultEntry();
      if(optional.isEmpty()){
        throw new IllegalStateException("Enchantment Registry does not have a default Value to fall back to");
      }
      return optional.get();
    }
    
    return world.getRegistryManager()
        .getOrThrow(RegistryKeys.ENCHANTMENT)
        .getEntry(enchantment);
  }
}
