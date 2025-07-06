package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.entity.ModStatusEffects;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.sounds.ModSounds;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AwesomeItem extends Item {
  public AwesomeItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if(world.isClient()){
      return ActionResult.SUCCESS;
    }
    if(!player.isCreative()){
      ItemStack stack = player.getStackInHand(hand);
      stack.decrement(1);
    }
    world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), ModSounds.SYRINGE_INJECTS, SoundCategory.PLAYERS);
    player.giveItemStack(new ItemStack(ModItems.EMPTY_SYRINGE));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 150, 4, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 700, 6, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(ModStatusEffects.RAD_X, 700, 9, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HASTE, 700, 9, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 700, 24, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 700, 9, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 700, 4, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 700, 9, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 700, 9, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 700, 9, false, false, true));
    player.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 700, 0, false, false, true));
    return ActionResult.SUCCESS_SERVER;
  }
}
