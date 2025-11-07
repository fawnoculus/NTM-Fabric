package net.fawnoculus.ntm.client.gui.handled;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.blocks.entities.container.energy.SimpleEnergyStorageBE;
import net.fawnoculus.ntm.client.gui.area.EnergyBar;
import net.fawnoculus.ntm.client.gui.widget.StorageModeWidget;
import net.fawnoculus.ntm.gui.handlers.EnergyStorageScreenHandler;
import net.fawnoculus.ntm.network.c2s.BEInteractionPayload;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class EnergyStorageScreen extends HandledScreen<EnergyStorageScreenHandler> {
	public EnergyStorageScreen(EnergyStorageScreenHandler handler, PlayerInventory inventory, Text title) {
		super(handler, inventory, title);
	}

	private static final Identifier TEXTURE = NTM.id("textures/gui/storage/energy_storage.png");
	private final SimpleEnergyStorageBE BE = this.handler.getBlockEntity();
	private final EnergyBar energyBar = new EnergyBar(62, 17, 52, 52, BE.energy, BE::getEnergyPerSec);

	@Override
	protected void init() {
		super.init();
		energyBar.setOffsets(this.x, this.y);
		this.addDrawable(energyBar);
		this.addDrawableChild(new StorageModeWidget(this.x + 133, this.y + 16, Text.translatable("narration.ntm.storage_mode_button.unpowered"), () -> BE.unpoweredMode,
		  () -> ClientPlayNetworking.send(new BEInteractionPayload(BE.getPos(), SimpleEnergyStorageBE.CYCLE_UNPOWERED_MODE))
		));
		this.addDrawableChild(new StorageModeWidget(this.x + 133, this.y + 52, Text.translatable("narration.ntm.storage_mode_button.powered"), () -> BE.poweredMode,
		  () -> ClientPlayNetworking.send(new BEInteractionPayload(BE.getPos(), SimpleEnergyStorageBE.CYCLE_POWERED_MODE))
		));
	}

	@Override
	protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
		context.drawTexture(RenderPipelines.GUI_TEXTURED, TEXTURE, this.x, this.y, 0, 0, this.backgroundWidth, this.backgroundHeight, 256, 256);
	}

	@Override
	public void render(DrawContext context, int mouseX, int mouseY, float deltaTicks) {
		super.render(context, mouseX, mouseY, deltaTicks);
		drawMouseoverTooltip(context, mouseX, mouseY);
	}
}
