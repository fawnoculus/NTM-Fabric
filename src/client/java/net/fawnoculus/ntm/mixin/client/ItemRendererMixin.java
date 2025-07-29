package net.fawnoculus.ntm.mixin.client;

import net.fawnoculus.ntm.render.ModModelRender;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BiConsumer;

@Mixin(ItemRenderer.class)
public abstract class ItemRendererMixin {
  @Inject(at = @At(value = "HEAD"),
      method = "renderItem(" +
          "Lnet/minecraft/entity/LivingEntity;" +
          "Lnet/minecraft/item/ItemStack;" +
          "Lnet/minecraft/item/ItemDisplayContext;" +
          "Lnet/minecraft/client/util/math/MatrixStack;" +
          "Lnet/minecraft/client/render/VertexConsumerProvider;" +
          "Lnet/minecraft/world/World;III" +
          ")V"
  )
  private void renderOverrideModels(LivingEntity entity, ItemStack stack, ItemDisplayContext displayContext, MatrixStack matrices, VertexConsumerProvider vertexConsumers, World world, int light, int overlay, int seed, CallbackInfo ci){
    BiConsumer<MatrixStack, Integer> renderOverride = ModModelRender.ITEM_LIGHT_RENDERERS.get(stack.getItem());
    if(renderOverride != null){
      renderOverride.accept(matrices, light);
      matrices.push();
      matrices.translate(1000f, 1000f, 1000f);
    }
  }
  @Inject(at = @At(value = "TAIL"),
      method = "renderItem(" +
          "Lnet/minecraft/entity/LivingEntity;" +
          "Lnet/minecraft/item/ItemStack;" +
          "Lnet/minecraft/item/ItemDisplayContext;" +
          "Lnet/minecraft/client/util/math/MatrixStack;" +
          "Lnet/minecraft/client/render/VertexConsumerProvider;" +
          "Lnet/minecraft/world/World;III" +
          ")V"
  )
  private void resetMatrix(LivingEntity entity, ItemStack stack, ItemDisplayContext displayContext, MatrixStack matrices, VertexConsumerProvider vertexConsumers, World world, int light, int overlay, int seed, CallbackInfo ci){
    if(ModModelRender.ITEM_LIGHT_RENDERERS.containsKey(stack.getItem())){
      matrices.pop();
    }
  }
}
