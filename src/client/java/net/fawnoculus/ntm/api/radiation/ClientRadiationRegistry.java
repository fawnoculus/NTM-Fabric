package net.fawnoculus.ntm.api.radiation;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.network.s2c.RadiationRegistryPayload;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class ClientRadiationRegistry {
	private static HashMap<Identifier, Double> radioactivityGetter = new HashMap<>();
	private static HashMap<Identifier, Double> radioactivityOverrides = new HashMap<>();

	public static double getRadioactivity(Iterable<ItemStack> stacks) {
		double radioactivity = 0;
		boolean hasTungstenReacher = false;
		for (ItemStack stack : stacks) {
			radioactivity += getRadioactivity(stack);
			if (stack.getItem() == NTMItems.TUNGSTEN_REACHER) {
				hasTungstenReacher = true;
			}
			if (stack.contains(DataComponentTypes.CONTAINER)) {
				radioactivity += getRadioactivity(
				  stack.getOrDefault(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT).stream().toList()
				);
			}
		}
		if (hasTungstenReacher) {
			radioactivity = Math.sqrt(radioactivity);
		}
		return radioactivity;
	}

	public static double getRadioactivity(World world) {
		try {
			return getRadioactivity(world.getRegistryManager().getOrThrow(RegistryKeys.DIMENSION_TYPE).getId(world.getDimension()));
		} catch (Throwable throwable) {
			return 0;
		}
	}

	public static double getRadioactivity(BlockState state) {
		return getRadioactivity(state.getBlock());
	}

	public static double getRadioactivity(Block block) {
		return getRadioactivity(Registries.BLOCK.getId(block));
	}

	public static double getRadioactivity(ItemStack stack) {
		return getRadioactivity(stack.getItem()) * stack.getCount();
	}

	public static double getRadioactivity(Item item) {
		return getRadioactivity(Registries.ITEM.getId(item));
	}

	public static double getRadioactivity(Identifier identifier) {
		Double override = radioactivityOverrides.get(identifier);
		if (override != null) {
			return override;
		}
		return radioactivityGetter.getOrDefault(identifier, 0.0);
	}

	public static void updateFromPacket(@NotNull RadiationRegistryPayload payload, ClientPlayNetworking.Context ignored) {
		radioactivityGetter = payload.serializedRegistry().radioactivityGetter();
		radioactivityOverrides = payload.serializedRegistry().radioactivityOverrides();
	}
}
