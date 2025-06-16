package net.fawnoculus.ntm.gui.handled_screens;

import net.fawnoculus.ntm.blocks.entities.AlloyFurnaceBE;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.gui.handlers.AlloyFurnaceScreenHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class AlloyFurnaceScreen extends HandledScreen<AlloyFurnaceScreenHandler> {
  public AlloyFurnaceScreen(AlloyFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }
  
  private static final Identifier TEXTURE = NTM.id("textures/gui/container/alloy_furnace.png");
  
  @Override
  protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x, this.y, 0.0F, 0.0F, this.backgroundWidth, this.backgroundHeight, 256, 256);
    
    
    AlloyFurnaceBE entity = this.handler.getBlockEntity();
    boolean showFire = entity.canCraft();
    int fuelBarSize = MathHelper.ceil(entity.getFuel() * 54);
    int progressBarSize = MathHelper.ceil(entity.getProgress() * 24);
    
    if(showFire) {
      context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x + 63, this.y + 38, 176, 0, 14, 14, 256, 256);
    }
    
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x + 101, this.y + 36, 176, 14, progressBarSize, 17, 256, 256);
    
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x + 43, this.y + 17 + 54 - fuelBarSize, 200, 54 - fuelBarSize, 18, fuelBarSize, 256, 256);
    
  }
  
  @Override
  public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
    super.render(context, mouseX, mouseY, deltaTicks);
    drawMouseoverTooltip(context, mouseX, mouseY);
  }
}
