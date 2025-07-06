package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.entity.ModDamageTypes;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.sounds.ModSounds;
import net.fawnoculus.ntm.util.EntityUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PoisonousInjectionItem extends Item {
  public PoisonousInjectionItem(Settings settings) {
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
    EntityUtil.applyDamage(player, (ServerWorld) world, ModDamageTypes.POISON_INJECTION, 30f);
    return ActionResult.SUCCESS_SERVER;
  }
}
