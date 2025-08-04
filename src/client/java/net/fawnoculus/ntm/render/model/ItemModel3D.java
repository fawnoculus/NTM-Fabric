package net.fawnoculus.ntm.render.model;

import net.fawnoculus.ntm.render.wavefront.Model3D;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.item.ItemRenderState.LayerRenderState;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;

public class ItemModel3D implements ItemModel {
  //TODO: WTF IS THIS, maybe use Special NTMModels?  net.minecraft.client.render.item.model.special.SpecialModelRenderer<T>
  public ItemModel3D(Model3D base){
    this.BASE = base;
  }

  private final Model3D BASE;

  @Override
  public void update(ItemRenderState state, ItemStack stack, ItemModelManager resolver, ItemDisplayContext displayContext, @Nullable ClientWorld world, @Nullable LivingEntity user, int seed) {
    LayerRenderState layer = state.newLayer();
    layer.setRenderLayer(RenderLayers.getItemLayer(stack));
  }
}
