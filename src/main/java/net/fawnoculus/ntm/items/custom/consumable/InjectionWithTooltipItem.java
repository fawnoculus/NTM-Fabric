package net.fawnoculus.ntm.items.custom.consumable;

import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class InjectionWithTooltipItem extends InjectionItem {
	private final int TOOLTIP_COUNT;

	public InjectionWithTooltipItem(Settings settings, SoundEvent sound, Item returnItem, BiConsumer<ServerWorld, LivingEntity> serverUse) {
		this(settings, 1, sound, returnItem, serverUse);
	}

	public InjectionWithTooltipItem(Settings settings, int tooltipCount, SoundEvent sound, Item returnItem, BiConsumer<ServerWorld, LivingEntity> serverUse) {
		super(settings, sound, returnItem, serverUse);

		this.TOOLTIP_COUNT = tooltipCount;
	}

	public InjectionWithTooltipItem(Settings settings, int tooltipCount, SoundEvent sound, List<Item> returnItems, BiConsumer<ServerWorld, LivingEntity> serverUse) {
		super(settings, sound, returnItems, serverUse);

		this.TOOLTIP_COUNT = tooltipCount;
	}

	@Override
	@SuppressWarnings("deprecation")
	public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
		if (this.TOOLTIP_COUNT == 1) {
			tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5)).formatted(Formatting.GRAY));
			return;
		}
		for (int i = 1; i <= this.TOOLTIP_COUNT; i++) {
			tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5) + i).formatted(Formatting.GRAY));
		}
	}
}
