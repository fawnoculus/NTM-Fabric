package net.fawnoculus.ntm.mixin;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.custom.multiblock.MultiblockBlock;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public abstract class BlockItemMixin {

  @Shadow public abstract Block getBlock();

  @Inject(
      method = "place(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/util/ActionResult;",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/item/BlockItem;getPlacementState(Lnet/minecraft/item/ItemPlacementContext;)Lnet/minecraft/block/BlockState;", shift = At.Shift.AFTER),
      cancellable = true
  )
  private static void placeMultiblock(ItemPlacementContext context, CallbackInfoReturnable<ActionResult> cir) {
    if (context.getPlayer() instanceof ServerPlayerEntity player
        && context.getWorld() instanceof ServerWorld serverWorld
        && context.getStack().getItem() instanceof BlockItem blockItem
        && blockItem.getBlock() instanceof MultiblockBlock multiblockBlock) {
      if(!multiblockBlock.getStructure().canPlaceStructure(serverWorld, context.getBlockPos(), player.getFacing())){
        ServerPlayNetworking.send(player, new AdvancedMessagePayload(new AdvancedMessage(
            NTM.id("place_multiblock"),
            Text.translatable("message.ntm.multiblock.not_enough_space").formatted(Formatting.RED),
            2000.0f))
        );
        cir.setReturnValue(ActionResult.FAIL);
      }
      multiblockBlock.getStructure().placeStructure(serverWorld, context.getBlockPos(), player.getFacing());
    }
  }
}
