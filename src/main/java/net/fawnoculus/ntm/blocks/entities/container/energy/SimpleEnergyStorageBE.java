package net.fawnoculus.ntm.blocks.entities.container.energy;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.fawnoculus.ntm.api.node.StorageMode;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.entities.InteractableBE;
import net.fawnoculus.ntm.gui.handlers.EnergyStorageScreenHandler;
import net.fawnoculus.ntm.items.custom.container.energy.EnergyContainingItem;
import net.fawnoculus.ntm.misc.stack.EnergyStack;
import net.fawnoculus.ntm.network.s2c.BlockPosPayload;
import net.fawnoculus.ntm.util.TextUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class SimpleEnergyStorageBE extends EnergyInventoryBE implements ExtendedScreenHandlerFactory<@NotNull BlockPosPayload>, InteractableBE {
    public static final Component NAME = Component.translatable("container.ntm.energy_storage");

    public static final int DISCHARGE_SLOT_INDEX = 0;
    public static final int CHARGE_SLOT_INDEX = 1;
    public static final Identifier CYCLE_POWERED_MODE = NTM.id("cycle_powered_mode");
    public static final Identifier CYCLE_UNPOWERED_MODE = NTM.id("cycle_unpowered_mode");
    public final EnergyStack.Storage energy = new EnergyStack.Storage(this).setStorageMode(StorageMode.Consume).onChange(this::setChanged);
    public boolean isPowered = false;
    public StorageMode poweredMode = StorageMode.Provide;
    public StorageMode unpoweredMode = StorageMode.Consume;
    public long previousEnergy = 0;
    public long[] energyChange = new long[20];
    public int energyChangeIndex = 0;

    public SimpleEnergyStorageBE(BlockPos pos, BlockState state) {
        super(NTMBlockEntities.SIMPLE_ENERGY_STORAGE_BE, pos, state, 2);
    }

    public static void tick(Level ignored, BlockPos ignored2, BlockState ignored3, @NotNull SimpleEnergyStorageBE entity) {
        entity.processBatteries();
        entity.updateEnergyChange();
        entity.setChanged();
    }

    private void processBatteries() {
        ItemStack dischargeStack = getItem(DISCHARGE_SLOT_INDEX);
        if (dischargeStack.getItem() instanceof EnergyContainingItem energyContainingItem) {
            energyContainingItem.discharge(dischargeStack, this.energy);
        }
        ItemStack chargeStack = getItem(CHARGE_SLOT_INDEX);
        if (chargeStack.getItem() instanceof EnergyContainingItem energyContainingItem) {
            energyContainingItem.charge(chargeStack, this.energy);
        }
    }

    private void updateEnergyChange() {
        if (this.energyChangeIndex >= 20 || this.energyChangeIndex < 0) {
            this.energyChangeIndex = 0;
        }
        long energyDifference = this.energy.getValue() - this.previousEnergy;
        this.energyChange[this.energyChangeIndex] = energyDifference;
        this.energyChangeIndex++;
        this.previousEnergy = this.energy.getValue();
    }

    public void onBlockUpdate() {
        if (this.level != null) {
            boolean isNowPowered = this.level.getBestNeighborSignal(this.worldPosition) > 0;
            if (isNowPowered == isPowered) return;

            if (isNowPowered) {
                this.energy.setStorageMode(this.poweredMode);
            } else {
                this.energy.setStorageMode(this.unpoweredMode);
            }

            this.isPowered = isNowPowered;
        }
    }

    public Component getEnergyPerSec() {
        OptionalDouble optional = Arrays.stream(energyChange).average();
        long energyPerSec = (long) optional.orElse(0);
        if (energyPerSec < 0) {
            return TextUtil.unit(energyPerSec, "generic.ntm.energy_s").withStyle(ChatFormatting.RED);
        }

        ChatFormatting formatting = ChatFormatting.YELLOW;
        if (energyPerSec > 0) formatting = ChatFormatting.GREEN;

        return Component.literal("+").append(TextUtil.unit(energyPerSec, "generic.ntm.energy_s")).withStyle(formatting);
    }

    @Override
    public Collection<NodeValueContainer> getContainers() {
        return List.of(this.energy);
    }

    @Override
    protected void loadAdditional(ValueInput view) {
        super.loadAdditional(view);
        this.energy.readData(view);

        view.read("powered_mode", StorageMode.CODEC).ifPresent(mode -> this.poweredMode = mode);
        view.read("unpowered_mode", StorageMode.CODEC).ifPresent(mode -> this.unpoweredMode = mode);
        this.isPowered = view.getBooleanOr("is_powered", false);
        this.energyChangeIndex = Math.clamp(
          view.getIntOr("energy_change_index", 0), 0, energyChange.length - 1
        );

        Optional<long[]> optional = view.getOptionalLongArray("energy_change");
        if (optional.isPresent() && optional.get().length == this.energyChange.length) {
            this.energyChange = optional.get();
        }
    }

    @Override
    protected void saveAdditional(ValueOutput view) {
        view.store("powered_mode", StorageMode.CODEC, this.poweredMode);
        view.store("unpowered_mode", StorageMode.CODEC, this.unpoweredMode);
        view.putBoolean("is_powered", this.isPowered);
        view.putInt("energy_change_index", this.energyChangeIndex);
        view.putLongArray("energy_change", energyChange);

        this.energy.writeData(view);

        super.saveAdditional(view);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(@NotNull ServerPlayer player) {
        return new BlockPosPayload(this.worldPosition);
    }

    @Override
    public Component getDisplayName() {
        return NAME;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new EnergyStorageScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public void onInteraction(ServerPlayer source, Identifier action, CompoundTag extraData) {
        if (action.equals(CYCLE_POWERED_MODE)) {
            if (this.isPowered) {
                this.energy.setStorageMode(this.poweredMode.cycle());
            }
            this.poweredMode = this.poweredMode.cycle();
        } else if (action.equals(CYCLE_UNPOWERED_MODE)) {
            if (!this.isPowered) {
                this.energy.setStorageMode(this.unpoweredMode.cycle());
            }
            this.unpoweredMode = this.unpoweredMode.cycle();
        }
    }
}
