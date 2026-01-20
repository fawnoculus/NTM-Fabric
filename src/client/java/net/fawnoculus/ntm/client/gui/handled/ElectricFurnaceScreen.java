package net.fawnoculus.ntm.client.gui.handled;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.entities.ElectricFurnaceBE;
import net.fawnoculus.ntm.client.gui.area.EnergyBar;
import net.fawnoculus.ntm.gui.handlers.ElectricFurnaceScreenHandler;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

public class ElectricFurnaceScreen extends AbstractContainerScreen<ElectricFurnaceScreenHandler> {
    private static final Identifier TEXTURE = NTM.id("textures/gui/machine/electric_furnace.png");
    private final ElectricFurnaceBE BE = this.menu.getBlockEntity();
    private final EnergyBar energyBar = new EnergyBar(20, 17, 16, 52, BE.energy);

    public ElectricFurnaceScreen(ElectricFurnaceScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        energyBar.setOffsets(this.leftPos, this.topPos);
        this.addRenderableOnly(energyBar);
    }

    @Override
    protected void renderBg(GuiGraphics context, float deltaTicks, int mouseX, int mouseY) {
        context.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, 256, 256);

        if (BE.showFireInGUI()) {
            context.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos + 56, this.topPos + 35, 176, 0, 16, 16, 256, 256);
        }

        int maxProgress = this.menu.getPropertyDelegate().get(1);
        int progressBarSize = Mth.ceil(BE.getProgress(maxProgress) * 24);
        context.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos + 79, this.topPos + 35, 176, 17, progressBarSize, 17, 256, 256);
    }

    @Override
    public void render(GuiGraphics context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        renderTooltip(context, mouseX, mouseY);
    }
}
