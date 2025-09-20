package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.blocks.NTMBlocks;
import net.fawnoculus.ntm.render.resources.NTMModels;
import net.fawnoculus.ntm.render.resources.NTMTextures;
import net.fawnoculus.ntm.render.wavefront.model.SingleModel3d;
import net.minecraft.block.Block;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.util.math.RotationAxis;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class NTMModelRender {
  public static final HashMap<Item, Consumer<MatrixStack>> ITEM_RENDERERS = new HashMap<>();
  public static final HashMap<Item, BiConsumer<MatrixStack, Integer>> ITEM_LIGHT_RENDERERS = new HashMap<>();

  private static void register(BiConsumer<MatrixStack, Integer> renderFunc, @NotNull Block block) {
    register(renderFunc, block.asItem());
  }

  private static void register(BiConsumer<MatrixStack, Integer> renderFunc, Item item) {
    ITEM_LIGHT_RENDERERS.put(item, renderFunc);
    ITEM_RENDERERS.put(item, matrixStack -> renderFunc.accept(matrixStack, 15728880));
  }

  public static void initialize() {
    register(NTMModelRender.AlloyFurnaceExtension::renderItem, NTMBlocks.ALLOY_FURNACE_EXTENSION);
  }

  public static class AlloyFurnaceExtension {
    public final static SingleModel3d TOP = NTMModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Top", "");
    public final static SingleModel3d SIDE = NTMModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Side", "");
    public final static SingleModel3d BOTTOM = NTMModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Bottom", "");

    public static void renderItem(@NotNull MatrixStack matrices, int light) {
      matrices.push();
      matrices.translate(0, -0.25f, 0);
      matrices.scale(0.6f, 0.6f, 0.6f);
      matrices.multiply(RotationAxis.POSITIVE_Y.rotation(0.75f));
      matrices.multiply(RotationAxis.POSITIVE_Z.rotation(0.25f));
      matrices.multiply(RotationAxis.POSITIVE_X.rotation(0.25f));
      render(matrices, light);
      matrices.pop();
    }

    public static void render(@NotNull MatrixStack matrices, int light) {
      matrices.push();
      TOP.draw(matrices.peek(), light, NTMTextures.ALLOY_FURNACE_EXTENSION_TOP);
      SIDE.draw(matrices.peek(), light, NTMTextures.ALLOY_FURNACE_EXTENSION_SIDE);
      BOTTOM.draw(matrices.peek(), light, NTMTextures.ALLOY_FURNACE_EXTENSION_BOTTOM);
      matrices.pop();
    }
  }
}
