package net.fawnoculus.ntm.gui.area;

import net.fawnoculus.ntm.misc.stack.EnergyStack;
import net.fawnoculus.ntm.render.resources.NTMTextures;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class EnergyBar implements InfoBar {
  @SafeVarargs
  public EnergyBar(int x, int y, int width, int height, EnergyStack stack, Supplier<Text>... extraText) {
    this.X = x;
    this.Y = y;
    this.WIDTH = width;
    this.HEIGHT = height;
    this.STACK = stack;
    this.EXTRA_TEXT = extraText;
  }

  private final int X;
  private final int Y;
  private final int WIDTH;
  private final int HEIGHT;
  private final EnergyStack STACK;
  private final Supplier<Text>[] EXTRA_TEXT;

  private Identifier TEXTURE = NTMTextures.GENERIC_ENERGY_BAR;
  private int U = 0;
  private int V = 0;
  private int TEXTURE_WIDTH = 52;
  private int TEXTURE_HEIGHT = 52;

  private int OFFSET_X;
  private int OFFSET_Y;

  public void setTexture(Identifier texture, int u, int v, int textureWidth, int textureHeight) {
    this.TEXTURE = texture;
    this.U = u;
    this.V = v;
    this.TEXTURE_WIDTH = textureWidth;
    this.TEXTURE_HEIGHT = textureHeight;
  }

  public void setOffsets(int offsetX, int offsetY) {
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
    return this.U;
  }

  @Override
  public int getV() {
    return this.V;
  }

  @Override
  public int getTextureHeight() {
    return this.TEXTURE_HEIGHT;
  }

  @Override
  public int getTextureWidth() {
    return this.TEXTURE_WIDTH;
  }

  @Override
  public void appendTooltip(Consumer<Text> tooltip) {
    Text energyStored = TextUtil.unit(this.STACK.getValue());
    Text maxEnergy = TextUtil.unit(this.STACK.getMaxValue(), "generic.ntm.energy");

    tooltip.accept(Text.translatable("generic.ntm.amount_stored", energyStored, maxEnergy));

    for (Supplier<Text> supplier : EXTRA_TEXT) {
      tooltip.accept(supplier.get());
    }
  }

  @Override
  public Identifier getTexture() {
    return this.TEXTURE;
  }

  @Override
  public @Range(from = 0, to = 1) double getFillState() {
    return (double) this.STACK.getValue() / (double) this.STACK.getMaxValue();
  }
}
