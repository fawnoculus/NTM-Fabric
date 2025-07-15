package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.items.components.ModFoodComponents;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.misc.messages.AdvancedMessage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

public class DestructiveWaffleItem extends Item {
  public DestructiveWaffleItem(Settings settings) {
    super(settings.food(ModFoodComponents.WAFFLE_OF_MASS_DESTRUCTION));
  }
  
  @Override
  public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
    if(user instanceof ServerPlayerEntity player){
      ServerPlayNetworking.send(player, new AdvancedMessageS2CPayload(new AdvancedMessage(
          NTM.id("waffle_of_mass_destruction"),
          Text.literal("Now you would violently Explode, but Nuclear Explosions are not implemented yet").formatted(Formatting.RED),
          4000.0f)));
    }
    // TODO: this, once we have Nuclear Explosions
    return super.finishUsing(stack, world, user);
  }
}
