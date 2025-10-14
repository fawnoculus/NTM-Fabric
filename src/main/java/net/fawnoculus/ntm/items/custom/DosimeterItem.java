package net.fawnoculus.ntm.items.custom;

import net.fawnoculus.ntm.api.radiation.RadiationManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class DosimeterItem extends Item {
  public DosimeterItem(Settings settings) {
    super(settings);
  }

  private Text getRadsText(double milliRads) {
    if (milliRads > 3_600) {
      return Text.translatable("generic.ntm.radiation.rad_s", ">3.6").formatted(Formatting.GOLD);
    }
    if (milliRads > 1_000) {
      return Text.translatable("generic.ntm.radiation.rad_s", String.format("%.1f", milliRads / 1000)).formatted(Formatting.GOLD);
    }
    if (milliRads > 0) {
      return Text.translatable("generic.ntm.radiation.rad_s", String.format("%.1f", milliRads / 1000)).formatted(Formatting.YELLOW);
    }
    return Text.translatable("generic.ntm.radiation.rad_s", String.format("%.1f", milliRads / 1000)).formatted(Formatting.GREEN);
  }

  @Override
  public ActionResult use(World world, PlayerEntity user, Hand hand) {
    if (world.isClient()) {
      return ActionResult.SUCCESS;
    }

    double totalRadiation = RadiationManager.getTotalRadiation(user);

    user.sendMessage(Text.translatable("message.ntm.dosimeter").formatted(Formatting.GOLD), false);
    user.sendMessage(Text.translatable("message.ntm.radiation.environmental_radiation").append(getRadsText(totalRadiation)).formatted(Formatting.YELLOW), false);
    return ActionResult.SUCCESS_SERVER;
  }

  @Override
  public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
    // TODO: make it make noise
    super.inventoryTick(stack, world, entity, slot);
  }
}
