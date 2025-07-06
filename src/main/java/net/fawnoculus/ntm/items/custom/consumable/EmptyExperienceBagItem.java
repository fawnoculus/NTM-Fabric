package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.sounds.ModSounds;
import net.fawnoculus.ntm.util.PlayerUtil;
import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EmptyExperienceBagItem extends Item {
  public EmptyExperienceBagItem(Settings settings) {
    super(settings);
  }
  public static final int XP_PER_BAG = 500;
  
  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if(player.totalExperience < XP_PER_BAG){
      if(!world.isClient()){
        ServerPlayNetworking.send((ServerPlayerEntity) player, new AdvancedMessageS2CPayload(new AdvancedMessage(
            NTM.id("empty_xp_bag"),
            Text.translatable("message.ntm.not_enough_xp").formatted(Formatting.RED),
            1000.0f)));
      }
      return ActionResult.FAIL;
    }
    if(world.isClient()){
      return ActionResult.SUCCESS;
    }
    if(!player.isCreative()){
      ItemStack stack = player.getStackInHand(hand);
      stack.decrement(1);
    }
    world.playSound(null, BlockPos.ofFloored(player.getPos()).up(), ModSounds.IV_BAG_INJECTS, SoundCategory.PLAYERS);
    PlayerUtil.removeExperience(player, XP_PER_BAG);
    player.getInventory().offerOrDrop(new ItemStack(ModItems.EXPERIENCE_BAG));
    
    return ActionResult.SUCCESS_SERVER;
  }
}