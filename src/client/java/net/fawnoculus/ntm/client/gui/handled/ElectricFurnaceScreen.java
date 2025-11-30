package net.fawnoculus.ntm.client.gui.handled;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.entities.ElectricFurnaceBE;
import net.fawnoculus.ntm.client.gui.area.EnergyBar;
import net.fawnoculus.ntm.gui.handlers.ElectricFurnaceScreenHandler;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class ElectricFurnaceScreen extends HandledScreen<ElectricFurnaceScreenHandler> {
    private static final Identifier TEXTURE = NTM.id("textures/gui/machine/electric_furnace.png");
    private final ElectricFurnaceBE BE = this.handler.getBlockEntity();
    private final EnergyBar energyBar = new EnergyBar(20, 17, 16, 52, BE.energy);
    public ElectricFurnaceScreen(ElectricFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        energyBar.setOffsets(this.x, this.y);
        this.addDrawable(energyBar);
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
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        drawMouseoverTooltip(context, mouseX, mouseY);
    }
}
