package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.items.custom.TooltipItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ConsumableComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class DrinkCanItem extends TooltipItem {
  public DrinkCanItem(Settings settings, List<StatusEffectInstance> effects) {
    super(settings.component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK));

    this.EFFECTS = effects;
  }

  public DrinkCanItem(Settings settings, int tooltipCount, List<StatusEffectInstance> effects) {
    super(settings.component(DataComponentTypes.CONSUMABLE, ConsumableComponents.DRINK), tooltipCount);

    this.EFFECTS = effects;
  }

  private final List<StatusEffectInstance> EFFECTS;

  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    if (user instanceof PlayerEntity player && !player.isCreative()) {
      stack.decrement(1);
      player.getInventory().offerOrDrop(new ItemStack(NTMItems.EMPTY_CAN));
      player.getInventory().offerOrDrop(new ItemStack(NTMItems.RING_PULL));
    }

    for (StatusEffectInstance effect : EFFECTS) {
      user.addStatusEffect(new StatusEffectInstance(effect));
    }

    return super.finishUsing(stack, world, user);
  }
}
