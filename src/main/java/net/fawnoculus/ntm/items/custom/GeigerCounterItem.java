package net.fawnoculus.ntm.items.custom;

import net.fawnoculus.ntm.world.radiation.ServerRadiationManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GeigerCounterItem extends Item {
  public GeigerCounterItem(Settings settings) {
    super(settings);
  }
  
  private Text getRadsText(double milliRads){
    if(milliRads > 1_000_000){
      return Text.translatable("message.ntm.radiation.rads", String.format("%.1f", milliRads / 1000)).formatted(Formatting.DARK_GRAY);
    }
    if(milliRads > 100_000){
      return Text.translatable("message.ntm.radiation.rads", String.format("%.1f", milliRads / 1000)).formatted(Formatting.DARK_RED);
    }
    if(milliRads > 10_000){
      return Text.translatable("message.ntm.radiation.rads", String.format("%.1f", milliRads / 1000)).formatted(Formatting.RED);
    }
    if(milliRads > 1_000){
      return Text.translatable("message.ntm.radiation.rads", String.format("%.1f", milliRads / 1000)).formatted(Formatting.GOLD);
    }
    if(milliRads > 0){
      return Text.translatable("message.ntm.radiation.rads", String.format("%.1f", milliRads / 1000)).formatted(Formatting.YELLOW);
    }
    return Text.translatable("message.ntm.radiation.rads", String.format("%.1f", milliRads / 1000)).formatted(Formatting.GREEN);
  }
  
  private Text getRadText(double milliRad){
    if(milliRad > 900_000){
      return Text.translatable("message.ntm.radiation.rad", String.format("%.1f", milliRad / 1000)).formatted(Formatting.DARK_GRAY);
    }
    if(milliRad > 800_000){
      return Text.translatable("message.ntm.radiation.rad", String.format("%.1f", milliRad / 1000)).formatted(Formatting.DARK_RED);
    }
    if(milliRad > 600_000){
      return Text.translatable("message.ntm.radiation.rad", String.format("%.1f", milliRad / 1000)).formatted(Formatting.RED);
    }
    if(milliRad > 400_000){
      return Text.translatable("message.ntm.radiation.rad", String.format("%.1f", milliRad / 1000)).formatted(Formatting.GOLD);
    }
    if(milliRad > 200_000){
      return Text.translatable("message.ntm.radiation.rad", String.format("%.1f", milliRad / 1000)).formatted(Formatting.YELLOW);
    }
    return Text.translatable("message.ntm.radiation.rad", String.format("%.1f", milliRad / 1000)).formatted(Formatting.GREEN);
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity user, Hand hand) {
    if(!(world instanceof ServerWorld serverWorld) || ServerRadiationManager.getInstance() == null){
      return ActionResult.SUCCESS;
    }
    ServerRadiationManager radiationManager = ServerRadiationManager.getInstance();
    
    double chunkRadiation = radiationManager.getChunkRadiation(serverWorld, user.getPos());
    double totalRadiation = radiationManager.getTotalRadiation((ServerPlayerEntity) user);
    double playerContamination = radiationManager.getRadiationExposure((ServerPlayerEntity) user);
    double playerResistance = radiationManager.getRadiationResistance((ServerPlayerEntity) user);
    double playerResistancePercentage = radiationManager.getRadiationResistancePercentage((ServerPlayerEntity) user);
    
    Text player_resistance = Text.literal(String.format("%.1f%% (%.1f)", playerResistance, playerResistancePercentage)).formatted(Formatting.WHITE);
    
    user.sendMessage(Text.translatable("message.ntm.geiger_counter").formatted(Formatting.GOLD), false);
    user.sendMessage(Text.translatable("message.ntm.radiation.chunk_radiation").append(getRadsText(chunkRadiation)).formatted(Formatting.YELLOW), false);
    user.sendMessage(Text.translatable("message.ntm.radiation.environmental_radiation").append(getRadsText(totalRadiation)).formatted(Formatting.YELLOW), false);
    user.sendMessage(Text.translatable("message.ntm.radiation.player_contamination").append(getRadText(playerContamination)).formatted(Formatting.YELLOW), false);
    user.sendMessage(Text.translatable("message.ntm.radiation.player_resistance").append(player_resistance).formatted(Formatting.YELLOW), false);
    return ActionResult.SUCCESS_SERVER;
  }
  
  @Override
  public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
    // TODO: make it make noise
    super.inventoryTick(stack, world, entity, slot);
  }
}
