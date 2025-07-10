package net.fawnoculus.ntm.util;

import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.command.CommandManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Predicate;

public class EnchantmentUtil {
  // This class is a fucking mess
  // Registries are stupid
  // if you get this working i will see you as a god
  
  private static final CommandRegistryAccess registryAccess = CommandManager.createRegistryAccess(BuiltinRegistries.createWrapperLookup());
  
  
  public static boolean hasEnchantment( ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey){
    return EnchantmentHelper.getLevel(getEnchantmentEntry(enchantmentRegistryKey), stack) > 0;
  }
  
  public static void addEnchantment(@NotNull ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey, int level){
    RegistryEntry<Enchantment> enchantmentRegistryEntry = getEnchantmentEntry(enchantmentRegistryKey);
    stack.addEnchantment(enchantmentRegistryEntry, level);
  }
  
  public static void removeEnchantment(@NotNull ItemStack stack, RegistryKey<Enchantment> enchantmentRegistryKey){
    /*
    RegistryEntry<Enchantment> enchantment = getEnchantmentEntry(enchantmentRegistryKey);
    
    ItemEnchantmentsComponent itemEnchantmentsComponent = stack.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);
    ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(itemEnchantmentsComponent);
    builder.remove(Predicate.isEqual(enchantment));
    
    stack.set(DataComponentTypes.ENCHANTMENTS, builder.build());
     */
  }
  
  public static @Nullable RegistryEntry<Enchantment> getEnchantmentEntry(@NotNull RegistryKey<Enchantment> enchantmentRegistryKey){
    return null;
    
    //return registryAccess.getOrThrow(RegistryKeys.ENCHANTMENT).getOptional(enchantmentRegistryKey).get();
    
    // why is ist so incredibly tedious to get a Registry Entry from a Registry Key????
    
    // WTF why does it all just not work!!?!?!?!?!?!??!?!??!?
  }
}
