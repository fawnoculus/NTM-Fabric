package net.fawnoculus.ntm.gui.handled;

import net.fawnoculus.ntm.blocks.entities.container.energy.SimpleEnergyStorageBE;
import net.fawnoculus.ntm.gui.handlers.EnergyStorageScreenHandler;
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

public class EnergyStorageScreen extends HandledScreen<EnergyStorageScreenHandler> {
  public EnergyStorageScreen(EnergyStorageScreenHandler handler, PlayerInventory inventory, Text title) {
    super(handler, inventory, title);
  }
  
  private static final Identifier TEXTURE = NTMTextures.ENERGY_STORAGE_GUI;
  
  @Override
  protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight, 256, 256);
    
    SimpleEnergyStorageBE entity = this.handler.getBlockEntity();
    int energyBarSize = MathHelper.ceil(
        (double) entity.getValue() / (double) entity.getMaxValue() * 52
    );
    
    context.drawTexture(RenderLayer::getGuiTextured, TEXTURE, this.x + 62, this.y + 17 + 52 - energyBarSize, 176, 52 - energyBarSize, 52, energyBarSize, 256, 256);
    
    int relativeMouseX = mouseX - this.x;
    int relativeMouseY = mouseY - this.y;
    
    if(
        relativeMouseX > 61 && relativeMouseX < 114
        && relativeMouseY > 16 && relativeMouseY < 69
    ){
      Text energyStored = TextUtil.unit(entity.getValue());
      Text maxEnergy = TextUtil.unit(entity.getMaxValue(), "generic.ntm.energy");
      
      Text energyTooltip = Text.translatable("generic.ntm.amount_stored", energyStored, maxEnergy);
      
      context.drawTooltip(ClientUtil.getTextRenderer(), List.of(energyTooltip, entity.getEnergyPerSec()), mouseX, mouseY);
    }
  }
  
  @Override
  public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
    super.render(context, mouseX, mouseY, deltaTicks);
    drawMouseoverTooltip(context, mouseX, mouseY);
  }
}
