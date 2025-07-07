package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.items.components.ModFoodComponents;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;

public class DestructiveWaffleItem extends Item {
  public DestructiveWaffleItem(Settings settings) {
    super(settings.food(ModFoodComponents.WAFFLE_OF_MASS_DESTRUCTION));
  }
  
  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    if(user instanceof PlayerEntity player && !world.isClient()){
      player.sendMessage(Text.literal("Now you would violently Explode, but Nuclear Explosions are not implemented yet"), false);
    }
    // TODO: this, once we have Nuclear Explosions
    return super.finishUsing(stack, world, user);
  }
}
