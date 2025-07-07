package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.items.components.ModFoodComponents;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ScrapPancakeItem extends Item {
  public ScrapPancakeItem(Settings settings) {
    super(settings.food(ModFoodComponents.SCRAP_PANCAKE));
  }
  
  @Override
  public ActionResult use(World world, PlayerEntity player, Hand hand) {
    if (world.isClient()) {
      return super.use(world, player, hand);
    }
    // TODO: this, once we have lunar cybernetic armor
    ServerPlayNetworking.send((ServerPlayerEntity) player, new AdvancedMessageS2CPayload(new AdvancedMessage(
        NTM.id("scrap_pancake"),
        Text.translatable("message.ntm.teeth_to_soft").formatted(Formatting.YELLOW),
        1000.0f)));
    return ActionResult.FAIL;
  }
  
  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    // TODO: this, once we have lunar cybernetic armor
    return super.finishUsing(stack, world, user);
  }
}
