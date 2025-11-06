package net.fawnoculus.ntm.api.tool;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public record ModifierHandler(List<Pair<ItemModifier, @NotNull Integer>> MODIFIERS) {
	public static Builder builder() {
		return new Builder();
	}

	public void appendTooltip(Consumer<Text> tooltip) {
		if (!MODIFIERS.isEmpty()) {
			tooltip.accept(Text.translatable("tooltip.ntm.modifier.start").formatted(Formatting.GRAY));
			for (Pair<ItemModifier, @NotNull Integer> pair : MODIFIERS) {
				tooltip.accept(Text.literal("  ").append(pair.getLeft().getFullName(pair.getRight()).formatted(Formatting.RED)));
			}
		}
	}

	public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		for (Pair<ItemModifier, @NotNull Integer> pair : MODIFIERS) {
			pair.getLeft().postHit(stack, target, attacker, pair.getRight());
		}
	}

	public static class Builder {
		private final List<Pair<ItemModifier, @NotNull Integer>> modifiers = new ArrayList<>();

		/**
		 * Use this one if the Modifier doesn't support levels
		 *
		 * @param modifier The Modifier to add
		 */
		public Builder addModifier(ItemModifier modifier) {
			modifiers.add(new Pair<>(modifier, 0));
			return this;
		}

		/**
		 * Use this one if the Modifier supports levels
		 *
		 * @param modifier The Modifier to add
		 * @param level    the level of the modifier
		 */
		public Builder addModifier(ItemModifier modifier, int level) {
			modifiers.add(new Pair<>(modifier, level));
			return this;
		}

		public ModifierHandler build() {
			return new ModifierHandler(modifiers);
		}
	}
}
