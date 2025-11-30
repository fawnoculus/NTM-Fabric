package net.fawnoculus.ntm.client.api.radiation;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.network.s2c.HazmatRegistryPayload;
import net.minecraft.entity.EquipmentHolder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class ClientHazmatRegistry {
    private static HashMap<Identifier, Double> hazmatGetter = new HashMap<>();
    private static HashMap<Identifier, Double> hazmatOverrides = new HashMap<>();

    public static double getResistance(LivingEntity entity) {
        double resistance = 0;
        if (entity instanceof EquipmentHolder equipmentHolder) {
            try {
                resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.HEAD));
            } catch (Throwable ignored) {
            }
            try {
                resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.CHEST));
            } catch (Throwable ignored) {
            }
            try {
                resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.LEGS));
            } catch (Throwable ignored) {
            }
            try {
                resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.FEET));
            } catch (Throwable ignored) {
            }
            try {
                resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.BODY));
            } catch (Throwable ignored) {
            }
            try {
                resistance += getResistance(equipmentHolder.getEquippedStack(EquipmentSlot.SADDLE));
            } catch (Throwable ignored) {
            }
        }
        return resistance;
    }

    public static double getResistance(ItemStack stack) {
        return getResistance(stack.getItem()) * stack.getCount();
    }

    public static double getResistance(Item item) {
        return getResistance(Registries.ITEM.getId(item));
    }

    public static double getResistance(Identifier identifier) {
        Double override = hazmatOverrides.get(identifier);
        if (override != null) {
            return override;
        }
        return hazmatGetter.getOrDefault(identifier, 0.0);
    }

    public static void updateFromPacket(HazmatRegistryPayload payload, ClientPlayNetworking.Context ignored) {
        hazmatGetter = payload.serializedRegistry().hazmatGetter();
        hazmatOverrides = payload.serializedRegistry().hazmatOverrides();
    }
}
