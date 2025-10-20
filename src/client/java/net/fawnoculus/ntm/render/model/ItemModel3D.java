package net.fawnoculus.ntm.render.model;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.NTMClient;
import net.fawnoculus.ntm.render.wavefront.model.Model3d;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.item.ItemRenderState.LayerRenderState;
import net.minecraft.client.render.item.model.BasicItemModel;
import net.minecraft.client.render.item.model.ItemModel;
import net.minecraft.client.render.model.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ItemModel3D implements ItemModel {
  private final List<BakedQuad> quads;
  private final Supplier<Vector3f[]> vector;
  private final ModelSettings settings;

  public ItemModel3D(List<BakedQuad> quads, ModelSettings settings) {
    this.quads = quads;
    this.settings = settings;
    this.vector = Suppliers.memoize(() -> BasicItemModel.bakeQuads(this.quads));
  }

  @Override
  public void update(ItemRenderState state, ItemStack stack, ItemModelManager resolver, ItemDisplayContext displayContext, @Nullable ClientWorld world, @Nullable LivingEntity user, int seed) {
    LayerRenderState layer = state.newLayer();

    layer.setVertices(this.vector);
    layer.setRenderLayer(RenderLayers.getItemLayer(stack));
    this.settings.addSettings(layer, displayContext);
    layer.getQuads().addAll(this.quads);
  }

  public record Unbaked(Identifier model, Model3d model3d, Function<Vector3f, Vector3f> offset) implements ItemModel.Unbaked {
    /* How the hell am I going to put a Wavefront model in a codec?
    public static final MapCodec<ItemModel3D.Unbaked> CODEC = RecordCodecBuilder.mapCodec(
      instance -> instance.group(
          Identifier.CODEC.fieldOf("model").forGetter(ItemModel3D.Unbaked::model)
        )
        .apply(instance, ItemModel3D.Unbaked::new)
    );
     */

    public Unbaked(Identifier model, Model3d model3d){
      this(model, model3d, vector3f -> vector3f);
    }

    @Override
    public void resolve(ResolvableModel.Resolver resolver) {
      resolver.markDependency(this.model);
    }

    @Override
    public ItemModel bake(ItemModel.BakeContext context) {

      Baker baker = context.blockModelBaker();
      BakedSimpleModel bakedSimpleModel = baker.getModel(this.model);
      ModelTextures modelTextures = bakedSimpleModel.getTextures();
      ModelSettings modelSettings = ModelSettings.resolveSettings(baker, bakedSimpleModel, modelTextures);

      List<BakedQuad> quads = model3d.bake(baker, bakedSimpleModel, offset);

      return new ItemModel3D(quads, modelSettings);
    }

    @Override
    public MapCodec<ItemModel3D.Unbaked> getCodec() {
      NTMClient.LOGGER.warn("FUCK this is actually called somewhere");
      NTMClient.LOGGER.warn("This is probably not good");
      return null;
    }
  }
}
