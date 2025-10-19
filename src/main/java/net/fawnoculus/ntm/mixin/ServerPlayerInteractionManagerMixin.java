package net.fawnoculus.ntm.mixin;

import net.fawnoculus.ntm.api.tool.SpecialTool;
import net.minecraft.block.BlockState;
import net.minecraft.block.OperatorBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerInteractionManager.class)
public abstract class ServerPlayerInteractionManagerMixin {
  @Shadow
  @Final
  protected ServerPlayerEntity player;

  @Shadow
  protected ServerWorld world;

  @Inject(method = "tryBreakBlock", at = @At(value = "HEAD"))
  private void preBreakBlock(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
    if (player.getMainHandStack().getItem() instanceof SpecialTool specialTool) {
      ItemStack stack = player.getMainHandStack();
      BlockState state = world.getBlockState(pos);

      if (stack.canMine(state, world, pos, player) && !(world.getBlockState(pos).getBlock() instanceof OperatorBlock && !player.isCreativeLevelTwoOp())) {
        specialTool.preMine(stack, world, state, pos, player);
      }
    }
  }
}
