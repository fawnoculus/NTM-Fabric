package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.sounds.ModSounds;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ExperienceBagItem  extends Item {
  public ExperienceBagItem(Settings settings) {
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
    world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), ModSounds.IV_BAG_INJECTS, SoundCategory.PLAYERS);
    player.getInventory().offerOrDrop(new ItemStack(ModItems.EMPTY_EXPERIENCE_BAG));
    player.addExperience(EmptyExperienceBagItem.XP_PER_BAG);
    
    return ActionResult.SUCCESS_SERVER;
  }
}