package net.fawnoculus.ntm.gui.widget;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.tool.ItemAbility;
import net.fawnoculus.ntm.gui.screen.ToolAbilityCustomizationScreen.ModifiablePreset;
import net.fawnoculus.ntm.misc.NTMSounds;
import net.fawnoculus.ntm.util.ClientUtil;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.client.sound.SoundManager;
import net.minecraft.util.Colors;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Range;

import java.util.List;

public class ToolAbilityWidget extends ClickableWidget {
	private static final int WIDTH = 16;
	private static final int HEIGHT = 16;
	private static final int TEXTURE_WIDTH = 16;
	private static final int TEXTURE_HEIGHT = 16;
	private static final Identifier LEVEL_TEXTURE = NTM.id("textures/gui/ability/screen.png");
	private static final int LEVEL_TEXTURE_WIDTH = 256;
	private static final int LEVEL_TEXTURE_HEIGHT = 128;
	private static final int LEVEL_TEXTURE_V = 106;

	private final @Range(from = 0, to = 10) int MAX_LEVEL;
	private final boolean IS_BOTTOM;
	private final ItemAbility ABILITY;
	private final List<ToolAbilityWidget> ROW;
	private final List<ToolAbilityWidget> OPPOSITE_ROW;
	private ModifiablePreset preset;
	private boolean isDisabled;
	private int currentLevel = -1;

	public ToolAbilityWidget(int x, int y, ItemAbility ability, int maxLevel, boolean isBottom, List<ToolAbilityWidget> row, List<ToolAbilityWidget> oppositeRow) {
		super(x, y, WIDTH, HEIGHT, maxLevel >= 1 ? ability.getFullName(maxLevel) : ability.getFullName(0));

		this.MAX_LEVEL = ability.isNone() ? 1 : maxLevel;
		this.IS_BOTTOM = isBottom;
		this.ABILITY = ability;
		this.ROW = row;
		this.OPPOSITE_ROW = oppositeRow;

		this.isDisabled = this.MAX_LEVEL < 1;
	}

	@Override
	protected void renderWidget(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
		if (this.isHovered()) {
			context.drawBorder(this.getX() - 1, this.getY() - 1, this.getWidth() + 2, this.getHeight() + 2, Colors.GRAY);
		}

		if (this.currentLevel >= 0) {
			context.drawBorder(this.getX() - 1, this.getY() - 1, this.getWidth() + 2, this.getHeight() + 2, Colors.WHITE);
		}

		if (this.ABILITY.maxLevel() > 1) {
			context.drawTexture(
			  RenderPipelines.GUI_TEXTURED,
			  LEVEL_TEXTURE,
			  this.getX() + WIDTH + 1, this.getY() + 1,
			  Math.clamp(currentLevel, 0, 10) * 2, LEVEL_TEXTURE_V,
			  2, 14,
			  LEVEL_TEXTURE_WIDTH, LEVEL_TEXTURE_HEIGHT
			);
		}

		if (this.isDisabled) {
			context.drawTexture(
			  RenderPipelines.GUI_TEXTURED,
			  this.ABILITY.getDisabledTexture(),
			  this.getX(), this.getY(),
			  0, 0,
			  WIDTH, HEIGHT,
			  TEXTURE_WIDTH, TEXTURE_HEIGHT
			);
		} else {
			context.drawTexture(
			  RenderPipelines.GUI_TEXTURED,
			  this.ABILITY.getEnabledTexture(),
			  this.getX(), this.getY(),
			  0, 0,
			  WIDTH, HEIGHT,
			  TEXTURE_WIDTH, TEXTURE_HEIGHT
			);
		}
	}

	@Override
	protected void appendClickableNarrations(NarrationMessageBuilder builder) {
	}

	public void setLevel(int level) {
		if (level < 0) {
			this.currentLevel = -1;
			this.setMessage(this.ABILITY.getName());
			return;
		}

		this.currentLevel = level;
		this.setMessage(this.ABILITY.getFullName(this.currentLevel));

		if (this.preset != null) {
			if (this.IS_BOTTOM) {
				this.preset.setBottomAbility(this.ABILITY, level);
			} else {
				this.preset.setTopAbility(this.ABILITY, level);
			}
		}


		for (ToolAbilityWidget widget : ROW) {
			if (widget == this) continue;
			widget.setLevel(-1);
		}
		for (ToolAbilityWidget widget : OPPOSITE_ROW) {
			if (widget.ABILITY.isNone() && this.ABILITY.disablesOtherRow()) {
				widget.setLevel(0);
				continue;
			}
			widget.forceDisable(this.ABILITY.disablesOtherRow());
		}
	}


	public void setPreset(ModifiablePreset preset) {
		assert preset != null;
		this.preset = preset;
		if (this.IS_BOTTOM && this.ABILITY == preset.bottomAbility) {
			this.setLevel(preset.bottomAbilityLevel);
		}
		if (!this.IS_BOTTOM && this.ABILITY == preset.topAbility) {
			this.setLevel(preset.topAbilityLevel);
		}
	}

	public void forceDisable(boolean disable) {
		if (disable) {
			this.isDisabled = true;
			this.setLevel(-1);
		} else {
			this.isDisabled = this.MAX_LEVEL < 1;
		}
	}

	@Override
	public void playDownSound(SoundManager soundManager) {
	}

	@Override
	public void onClick(double mouseX, double mouseY) {
		if (this.isDisabled) return;

		int previousLevel = currentLevel;

		if (this.MAX_LEVEL < 2) {
			if (this.currentLevel != this.MAX_LEVEL) {
				this.setLevel(this.MAX_LEVEL);
			}
		} else {
			this.setLevel(Math.max(0, this.currentLevel) % this.MAX_LEVEL + 1);
		}

		if (previousLevel != currentLevel) {
			ClientUtil.playSound(PositionedSoundInstance.master(NTMSounds.TECH_BOOP, 2));
		}
	}
}
