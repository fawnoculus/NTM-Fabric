package net.fawnoculus.ntm.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ItemEnchantmentsComponent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class EnchantmentUtil {
    public static void addEnchantment(@NotNull World world, RegistryKey<Enchantment> enchantmentKey, int level, @NotNull ItemStack stack) {
        RegistryEntry.Reference<Enchantment> enchantmentRegistryEntry = getEnchantmentEntry(world, enchantmentKey);
        stack.addEnchantment(enchantmentRegistryEntry, level);
    }

    public static void removeEnchantment(RegistryKey<Enchantment> enchantmentKey, @NotNull ItemStack stack) {
        ItemEnchantmentsComponent itemEnchantmentsComponent = stack.getOrDefault(DataComponentTypes.ENCHANTMENTS, ItemEnchantmentsComponent.DEFAULT);
        ItemEnchantmentsComponent.Builder builder = new ItemEnchantmentsComponent.Builder(itemEnchantmentsComponent);
        builder.remove(registryEntry -> registryEntry.matchesId(enchantmentKey.getValue()));

        stack.set(DataComponentTypes.ENCHANTMENTS, builder.build());
    }

    public static @NotNull RegistryEntry.Reference<Enchantment> getEnchantmentEntry(@NotNull World world, @NotNull RegistryKey<Enchantment> enchantmentKey) {
        Optional<RegistryEntry.Reference<Enchantment>> enchantment = world.getRegistryManager()
          .getOrThrow(RegistryKeys.ENCHANTMENT)
          .getOptional(enchantmentKey);

        if (enchantment.isPresent()) {
            return enchantment.get();
        }

        Optional<RegistryEntry.Reference<Enchantment>> optional = world.getRegistryManager()
          .getOrThrow(RegistryKeys.ENCHANTMENT)
          .getDefaultEntry();
        if (optional.isEmpty()) {
            throw new IllegalStateException("Enchantment Registry does not have a default Value to fall back to");
        }
        return optional.get();
    }
}
