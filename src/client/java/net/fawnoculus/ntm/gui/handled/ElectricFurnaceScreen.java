package net.fawnoculus.ntm.gui.handled;

import net.fawnoculus.ntm.blocks.entities.ElectricFurnaceBE;
import net.fawnoculus.ntm.gui.area.EnergyBar;
import net.fawnoculus.ntm.gui.handlers.ElectricFurnaceScreenHandler;
import net.fawnoculus.ntm.render.resources.NTMTextures;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ElectricFurnaceScreen extends HandledScreen<ElectricFurnaceScreenHandler> {
  public ElectricFurnaceScreen(ElectricFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }

  private static final Identifier TEXTURE = NTMTextures.ELECTRIC_FURNACE_GUI;
  private final ElectricFurnaceBE BE = this.handler.getBlockEntity();
  private final EnergyBar energyBar = new EnergyBar(20, 17, 16, 52, BE.energy);

  @Override
  protected void init() {
    super.init();
    energyBar.setOffsets(this.x, this.y);
  }

  @Override
  protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
    context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight, 256, 256);

    if (BE.showFireInGUI()) {
      context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, this.x + 56, this.y + 35, 176, 0, 16, 16, 256, 256);
    }

    int maxProgress = this.handler.getPropertyDelegate().get(1);
    int progressBarSize = MathHelper.ceil(BE.getProgress(maxProgress) * 24);
    context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, this.x + 79, this.y + 35, 176, 17, progressBarSize, 17, 256, 256);

    energyBar.draw(context, mouseX, mouseY);
  }

  @Override
  public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
    super.render(context, mouseX, mouseY, deltaTicks);
    drawMouseoverTooltip(context, mouseX, mouseY);
  }
}
