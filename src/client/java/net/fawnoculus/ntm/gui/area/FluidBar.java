package net.fawnoculus.ntm.gui.area;

import net.fabricmc.fabric.api.transfer.v1.client.fluid.FluidVariantRendering;
import net.fawnoculus.ntm.blocks.node.NodeWithValue;
import net.fawnoculus.ntm.blocks.node.type.FluidNodeWithValue;
import net.fawnoculus.ntm.render.NTMTextures;
import net.fawnoculus.ntm.util.TextUtil;
import net.fawnoculus.ntm.util.fluid.FluidStack;
import net.fawnoculus.ntm.util.fluid.FluidUnit;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluidBar implements InfoBar{
  @SafeVarargs
  public FluidBar(int x, int y, int width, int height, FluidNodeWithValue fluidNode, Supplier<Text>... extraText){
    this(x, y, width, height, fluidNode.getFluidStorage(), extraText);
  }
  @SafeVarargs
  public FluidBar(int x, int y, int width, int height, FluidStack fluidStack, Supplier<Text>... extraText){
    this.X = x;
    this.Y = y;
    this.WIDTH = width;
    this.HEIGHT = height;
    this.FLUID_STACK = fluidStack;
    this.EXTRA_TEXT = extraText;
  }
  
  private final int X;
  private final int Y;
  private final int WIDTH;
  private final int HEIGHT;
  private final FluidStack FLUID_STACK;
  private final Supplier<Text>[] EXTRA_TEXT;
  
  private int OFFSET_X;
  private int OFFSET_Y;
  
  public void setOffsets(int offsetX, int offsetY){
    this.OFFSET_X = offsetX;
    this.OFFSET_Y = offsetY;
  }
  
  @Override
  public int getX() {
    return this.X;
  }
  
  @Override
  public int getY() {
    return this.Y;
  }
  
  @Override
  public int getWidth() {
    return this.WIDTH;
  }
  
  @Override
  public int getHeigh() {
    return this.HEIGHT;
  }
  
  @Override
  public int getOffsetX() {
    return this.OFFSET_X;
  }
  
  @Override
  public int getOffsetY() {
    return this.OFFSET_Y;
  }
  
  @Override
  public int getU() {
    return 0;
  }
  
  @Override
  public int getV() {
    return 0;
  }
  
  @Override
  public int getTextureHeight() {
    Sprite sprite = this.getFluidSprite();
    if(sprite == null) return 16;
    return sprite.getContents().getHeight();
  }
  
  @Override
  public int getTextureWidth() {
    Sprite sprite = this.getFluidSprite();
    if(sprite == null) return 16;
    return sprite.getContents().getWidth();
  }
  
  @Override
  public Identifier getTexture() {
    Sprite sprite = this.getFluidSprite();
    if(sprite == null) return null;
    return sprite.getAtlasId();
  }
  
  private @Nullable Sprite getFluidSprite(){
    return FluidVariantRendering.getSprite(this.FLUID_STACK.variant);
  }
  
  @Override
  public void appendTooltip(Consumer<Text> tooltip) {
    Text amount = Text.literal(String.format("%,d", this.FLUID_STACK.amount));
    Text capacity = FluidUnit.text(this.FLUID_STACK.getCapacity());
    
    tooltip.accept(Text.translatable("generic.ntm.amount_stored", amount, capacity));
    
    for(Supplier<Text> supplier : EXTRA_TEXT){
      tooltip.accept(supplier.get());
    }
  }
  
  @Override
  public @Range(from = 0, to = 1) double getFillState() {
    return (double) this.FLUID_STACK.amount / (double) this.FLUID_STACK.getCapacity();
  }
}
