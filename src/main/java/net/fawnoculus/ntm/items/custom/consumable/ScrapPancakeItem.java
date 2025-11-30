package net.fawnoculus.ntm.items.custom.consumable;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.items.components.NTMFoodComponents;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
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
        super(settings.food(NTMFoodComponents.SCRAP_PANCAKE));
    }

    @Override
    public ActionResult use(World world, PlayerEntity player, Hand hand) {
        // TODO: this, once we have lunar cybernetic armor
        ServerPlayNetworking.send((ServerPlayerEntity) player, new AdvancedMessagePayload(new AdvancedMessage(
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
