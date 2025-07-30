package net.fawnoculus.ntm.mixin.client;

import net.fawnoculus.ntm.render.NTMModelRender;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@Mixin(DrawContext.class)
public abstract class DrawContextMixin {
  @Shadow @Final private MatrixStack matrices;
  
  @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/math/MatrixStack;scale(FFF)V", shift = At.Shift.AFTER),
      method = "drawItem(" +
      "Lnet/minecraft/entity/LivingEntity;" +
      "Lnet/minecraft/world/World;" +
      "Lnet/minecraft/item/ItemStack;" +
      "IIII" +
      ")V")
  private void renderOverrideModels(LivingEntity entity, World world, ItemStack stack, int x, int y, int seed, int z, CallbackInfo ci){
    Consumer<MatrixStack> renderOverride = NTMModelRender.ITEM_RENDERERS.get(stack.getItem());
    if(renderOverride != null){
      renderOverride.accept(this.matrices);
      this.matrices.push();
      this.matrices.translate(1000f, 1000f, 1000f);
    }
  }
  @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/DrawContext;draw()V", shift = At.Shift.AFTER),
      method = "drawItem(" +
          "Lnet/minecraft/entity/LivingEntity;" +
          "Lnet/minecraft/world/World;" +
          "Lnet/minecraft/item/ItemStack;" +
          "IIII" +
          ")V")
  private void resetMatrix(LivingEntity entity, World world, ItemStack stack, int x, int y, int seed, int z, CallbackInfo ci){
    if(NTMModelRender.ITEM_RENDERERS.containsKey(stack.getItem())){
      this.matrices.pop();
    }
  }
}
