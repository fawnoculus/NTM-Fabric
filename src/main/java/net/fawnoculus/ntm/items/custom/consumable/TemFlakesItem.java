package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.components.NTMFoodComponents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class TemFlakesItem extends Item {
    public TemFlakesItem(Settings settings) {
        super(settings.food(NTMFoodComponents.ALWAYS_EDIBLE));
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        user.heal(2);
        return super.finishUsing(stack, world, user);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
        tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5)).formatted(Formatting.GRAY));
    }
}
