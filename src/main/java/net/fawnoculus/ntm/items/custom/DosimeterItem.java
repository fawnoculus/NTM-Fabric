package net.fawnoculus.ntm.items.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class DosimeterItem extends Item {
  public DosimeterItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity user, Hand hand) {
    if(world.isClient()){
      return ActionResult.SUCCESS;
    }
    // TODO: make this send the Player Radiation Values
    return ActionResult.SUCCESS_SERVER;
  }
}
