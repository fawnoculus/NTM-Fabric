package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.NTMDataComponentTypes;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class StylishFlaskItem extends Item {
  private static final int COOLDOWN_PER_USAGE = 3600;

  public StylishFlaskItem(Settings settings) {
    super(settings
      .component(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, 0)
      .component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK)
    );
  }

  @Override
  public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
    int cooldown = stack.getOrDefault(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, 0);
    if (cooldown > 0) {
      stack.set(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, cooldown - 1);
    }
  }

  @Override
  public ActionResult use(World world, PlayerEntity user, Hand hand) {
    if (world.isClient()) {
      return super.use(world, user, hand);
    }
    ItemStack stack = user.getStackInHand(hand);
    int cooldown = stack.getOrDefault(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, 0);
    if (cooldown > 0) {
      return ActionResult.FAIL;
    }
    return super.use(world, user, hand);
  }

  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0, false, false, true));
    user.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 600, 2, false, false, true));
    stack.set(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, COOLDOWN_PER_USAGE);
    ItemStack copy = stack.copy();
    super.finishUsing(stack, world, user);
    return copy;
  }

  @Override
  public boolean isItemBarVisible(ItemStack stack) {
    return stack.getOrDefault(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, 0) > 0;
  }

  @Override
  public int getItemBarStep(ItemStack stack) {
    int cooldown = stack.getOrDefault(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, 0);
    return MathHelper.clamp(Math.round(13.0F - cooldown * 13.0F / COOLDOWN_PER_USAGE), 0, 13);
  }

  @Override
  public int getItemBarColor(ItemStack stack) {
    int cooldown = stack.getOrDefault(NTMDataComponentTypes.COOLDOWN_COMPONENT_TYPE, 0);
    float f = Math.max(0.0F, ((float) COOLDOWN_PER_USAGE - cooldown) / (float) COOLDOWN_PER_USAGE);
    return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
  }

  @Override
  @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5) + 1).formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5) + 2).formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5) + 3).formatted(Formatting.GRAY));
    tooltip.accept(Text.literal(""));
    tooltip.accept(Text.translatable("tooltip." + this.getTranslationKey().substring(5) + 4).formatted(Formatting.GRAY));
  }
}
