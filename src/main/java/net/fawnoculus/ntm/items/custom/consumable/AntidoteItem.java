package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class AntidoteItem extends Item {
  public AntidoteItem(Settings settings) {
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
    player.clearStatusEffects();
    return ActionResult.PASS;
  }
}
