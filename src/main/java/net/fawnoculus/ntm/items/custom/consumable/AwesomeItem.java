package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.ModItems;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class AwesomeItem extends Item {
  public AwesomeItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if(world.isClient()){
      return ActionResult.CONSUME;
    }
    if(!player.isCreative()){
      ItemStack stack = player.getStackInHand(hand);
      stack.decrement(1);
    }
    player.giveItemStack(new ItemStack(ModItems.EMPTY_SYRINGE));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 5*20, 4, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 35*20, 6, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 35*20, 9, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 35*20, 24, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 35*20, 9, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 35*20, 4, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 35*20, 9, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 35*20, 9, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 35*20, 9, false, false));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 35*20, 0, false, false));
    return ActionResult.PASS;
  }
}
