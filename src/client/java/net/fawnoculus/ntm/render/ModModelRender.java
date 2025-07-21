package net.fawnoculus.ntm.render;

import net.fawnoculus.ntm.blocks.ModBlocks;
import net.fawnoculus.ntm.render.models.Model3D;
import net.minecraft.block.Block;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.util.math.RotationAxis;

import java.util.HashMap;
import java.util.function.Consumer;

public class ModModelRender {
  public static final HashMap<Item, Consumer<MatrixStack>> ITEM_RENDERERS = new HashMap<>();
  
  private static void register(Consumer<MatrixStack> renderFunc, Block block){
    register(renderFunc, block.asItem());
  }
  private static void register(Consumer<MatrixStack> renderFunc, Item item){
    ITEM_RENDERERS.put(item, renderFunc);
  }
  
  public static void initialize(){
    register(ModModelRender.AlloyFurnaceExtension::renderItem, ModBlocks.ALLOY_FURNACE_EXTENSION);
  }
  
  public static class AlloyFurnaceExtension{
    public final static Model3D TOP = ModModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Top", "");
    public final static Model3D SIDE = ModModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Side", "");
    public final static Model3D BOTTOM = ModModels.ALLOY_FURNACE_EXTENSION.getOrThrow("Bottom", "");
    
    public static void renderItem(MatrixStack matrices) {
      matrices.push();
      matrices.translate(0, -0.325f, 0);
      matrices.scale(0.75f, 0.75f, 0.75f);
      matrices.multiply(RotationAxis.POSITIVE_Y.rotation(0.5f));
      render(matrices);
      matrices.pop();
    }
    public static void render(MatrixStack matrices) {
      matrices.push();
      TOP.draw(matrices.peek(), ModTextures.ALLOY_FURNACE_EXTENSION_TOP);
      SIDE.draw(matrices.peek(), ModTextures.ALLOY_FURNACE_EXTENSION_SIDE);
      BOTTOM.draw(matrices.peek(), ModTextures.ALLOY_FURNACE_EXTENSION_BOTTOM);
      matrices.pop();
    }
  }
}
