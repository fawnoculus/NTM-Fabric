package net.fawnoculus.ntm.items.custom.consumable;

import net.fawnoculus.ntm.util.TriConsumer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class InjectionItem extends Item {
  public InjectionItem(Settings settings, @Nullable SoundEvent sound, @Nullable ItemStack returnItem, TriConsumer<ServerWorld, PlayerEntity, Hand> serverUse) {
    this(settings, sound, returnItem != null ? List.of(returnItem) : List.of(), serverUse);
  }
  public InjectionItem(Settings settings, @Nullable SoundEvent sound, List<ItemStack> returnItems, TriConsumer<ServerWorld, PlayerEntity, Hand> serverUse) {
    super(settings);
    
    this.SOUND = sound;
    this.RETURN_ITEMS = returnItems;
    this.SERVER_USE = serverUse;
  }
  
  
  private final @Nullable SoundEvent SOUND;
  private final List<ItemStack> RETURN_ITEMS;
  private final TriConsumer<ServerWorld, PlayerEntity, Hand> SERVER_USE;
  
  
  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if(world.isClient()){
      return ActionResult.SUCCESS;
    }
    if(!player.isCreative()){
      ItemStack stack = player.getStackInHand(hand);
      stack.decrement(1);
    }
    if(this.SOUND != null){
      world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), this.SOUND, SoundCategory.PLAYERS);
    }
    for(ItemStack returnItem : RETURN_ITEMS){
      player.getInventory().offerOrDrop(returnItem);
    }
    
    this.SERVER_USE.accept((ServerWorld) world, player, hand);
    
    return ActionResult.SUCCESS_SERVER;
  }
}
