package net.fawnoculus.ntm.gui.handled;

import net.fawnoculus.ntm.blocks.entities.ElectricFurnaceBE;
import net.fawnoculus.ntm.gui.handlers.ElectricFurnaceScreenHandler;
import net.fawnoculus.ntm.render.NTMTextures;
import net.fawnoculus.ntm.util.ClientUtil;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

public class ElectricFurnaceScreen extends HandledScreen<ElectricFurnaceScreenHandler> {
  public ElectricFurnaceScreen(ElectricFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }
  
  private static final Identifier TEXTURE = NTMTextures.ELECTRIC_FURNACE_GUI;
  
  @Override
  protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight, 256, 256);
    
    ElectricFurnaceBE entity = this.handler.getBlockEntity();
    boolean showFire = entity.showFireInGUI();
    int energyBarSize = MathHelper.ceil(
        (double) entity.getValue() / (double) entity.getMaxValue() * 52
    );
    
    int maxProgress = this.handler.getPropertyDelegate().get(1);
    int progressBarSize = MathHelper.ceil(entity.getProgress(maxProgress) * 24);
    
    if(showFire) {
      context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x + 56, this.y + 35, 176, 0, 16, 16, 256, 256);
    }
    
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x + 79, this.y + 35, 176, 17, progressBarSize, 17, 256, 256);
    
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x + 20, this.y + 17 + 52 - energyBarSize, 200, 52 - energyBarSize, 18, energyBarSize, 256, 256);
    
    int relativeMouseX = mouseX - this.x;
    int relativeMouseY = mouseY - this.y;
    
    if(
        relativeMouseX > 19 && relativeMouseX < 36
        && relativeMouseY > 16 && relativeMouseY < 69
    ){
      Text energyStored = TextUtil.unit(entity.getValue());
      Text maxEnergy = TextUtil.unit(entity.getMaxValue(), "generic.ntm.energy");
      
      Text energyTooltip = Text.translatable("generic.ntm.amount_stored", energyStored, maxEnergy);
      
      context.drawTooltip(ClientUtil.getTextRenderer(), List.of(energyTooltip), mouseX, mouseY);
    }
  }
  
  @Override
  public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
    super.render(context, mouseX, mouseY, deltaTicks);
    drawMouseoverTooltip(context, mouseX, mouseY);
  }
}
