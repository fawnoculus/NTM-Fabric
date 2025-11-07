package net.fawnoculus.ntm.client.gui.area;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.stack.EnergyStack;
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

	private static final Identifier TEXTURE = NTM.id("textures/gui/generic/energy_bar.png");
	private static final int U = 0;
	private static final int V = 0;
	private static final int TEXTURE_WIDTH = 52;
	private static final int TEXTURE_HEIGHT = 52;

	private int OFFSET_X;
	private int OFFSET_Y;

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
		return U;
	}

	@Override
	public int getV() {
		return V;
	}

	@Override
	public int getTextureHeight() {
		return TEXTURE_HEIGHT;
	}

	@Override
	public int getTextureWidth() {
		return TEXTURE_WIDTH;
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
		return TEXTURE;
	}

	@Override
	public @Range(from = 0, to = 1) double getFillState() {
		return (double) this.STACK.getValue() / (double) this.STACK.getMaxValue();
	}
}
