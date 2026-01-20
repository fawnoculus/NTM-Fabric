package net.fawnoculus.ntm.client.gui.handled;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.entities.container.energy.SimpleEnergyStorageBE;
import net.fawnoculus.ntm.client.gui.area.EnergyBar;
import net.fawnoculus.ntm.client.gui.widget.StorageModeWidget;
import net.fawnoculus.ntm.gui.handlers.EnergyStorageScreenHandler;
import net.fawnoculus.ntm.network.c2s.BEInteractionPayload;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

public class EnergyStorageScreen extends AbstractContainerScreen<EnergyStorageScreenHandler> {
    private static final Identifier TEXTURE = NTM.id("textures/gui/storage/energy_storage.png");
    private final SimpleEnergyStorageBE BE = this.menu.getBlockEntity();
    private final EnergyBar energyBar = new EnergyBar(62, 17, 52, 52, BE.energy, BE::getEnergyPerSec);

    public EnergyStorageScreen(EnergyStorageScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        energyBar.setOffsets(this.leftPos, this.topPos);
        this.addRenderableOnly(energyBar);
        this.addRenderableWidget(new StorageModeWidget(this.leftPos + 133, this.topPos + 16, Component.translatable("narration.ntm.storage_mode_button.unpowered"), () -> BE.unpoweredMode,
          () -> ClientPlayNetworking.send(new BEInteractionPayload(BE.getBlockPos(), SimpleEnergyStorageBE.CYCLE_UNPOWERED_MODE))
        ));
        this.addRenderableWidget(new StorageModeWidget(this.leftPos + 133, this.topPos + 52, Component.translatable("narration.ntm.storage_mode_button.powered"), () -> BE.poweredMode,
          () -> ClientPlayNetworking.send(new BEInteractionPayload(BE.getBlockPos(), SimpleEnergyStorageBE.CYCLE_POWERED_MODE))
        ));
    }

    @Override
    protected void renderBg(GuiGraphics context, float deltaTicks, int mouseX, int mouseY) {
        context.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, 256, 256);
    }

    @Override
    public void render(GuiGraphics context, int mouseX, int mouseY, float deltaTicks) {
        super.render(context, mouseX, mouseY, deltaTicks);
        renderTooltip(context, mouseX, mouseY);
    }
}
