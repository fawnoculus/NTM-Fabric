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
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;

public class SimpleEnergyStorageBE extends EnergyInventoryBE implements ExtendedScreenHandlerFactory<BlockPosPayload>, InteractableBE {
    public static final Text NAME = Text.translatable("container.ntm.energy_storage");

    public static final int DISCHARGE_SLOT_INDEX = 0;
    public static final int CHARGE_SLOT_INDEX = 1;
    public static final Identifier CYCLE_POWERED_MODE = NTM.id("cycle_powered_mode");
    public static final Identifier CYCLE_UNPOWERED_MODE = NTM.id("cycle_unpowered_mode");
    public final EnergyStack.Storage energy = new EnergyStack.Storage(this).setStorageMode(StorageMode.Consume).onChange(this::markDirty);
    public boolean isPowered = false;
    public StorageMode poweredMode = StorageMode.Provide;
    public StorageMode unpoweredMode = StorageMode.Consume;
    public long previousEnergy = 0;
    public long[] energyChange = new long[20];
    public int energyChangeIndex = 0;
    public SimpleEnergyStorageBE(BlockPos pos, BlockState state) {
        super(NTMBlockEntities.SIMPLE_ENERGY_STORAGE_BE, pos, state, 2);
    }

    public static void tick(World ignored, BlockPos ignored2, BlockState ignored3, @NotNull SimpleEnergyStorageBE entity) {
        entity.processBatteries();
        entity.updateEnergyChange();
        entity.markDirty();
    }

    private void processBatteries() {
        ItemStack dischargeStack = getStack(DISCHARGE_SLOT_INDEX);
        if (dischargeStack.getItem() instanceof EnergyContainingItem energyContainingItem) {
            energyContainingItem.discharge(dischargeStack, this.energy);
        }
        ItemStack chargeStack = getStack(CHARGE_SLOT_INDEX);
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
        if (this.world != null) {
            boolean isNowPowered = this.world.getReceivedRedstonePower(this.pos) > 0;
            if (isNowPowered == isPowered) return;

            if (isNowPowered) {
                this.energy.setStorageMode(this.poweredMode);
            } else {
                this.energy.setStorageMode(this.unpoweredMode);
            }

            this.isPowered = isNowPowered;
        }
    }

    public Text getEnergyPerSec() {
        OptionalDouble optional = Arrays.stream(energyChange).average();
        long energyPerSec = (long) optional.orElse(0);
        if (energyPerSec < 0) {
            return TextUtil.unit(energyPerSec, "generic.ntm.energy_s").formatted(Formatting.RED);
        }

        Formatting formatting = Formatting.YELLOW;
        if (energyPerSec > 0) formatting = Formatting.GREEN;

        return Text.literal("+").append(TextUtil.unit(energyPerSec, "generic.ntm.energy_s")).formatted(formatting);
    }

    @Override
    public Collection<NodeValueContainer> getContainers() {
        return List.of(this.energy);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        this.energy.readData(view);

        view.read("powered_mode", StorageMode.CODEC).ifPresent(mode -> this.poweredMode = mode);
        view.read("unpowered_mode", StorageMode.CODEC).ifPresent(mode -> this.unpoweredMode = mode);
        this.isPowered = view.getBoolean("is_powered", false);
        this.energyChangeIndex = Math.clamp(
          view.getInt("energy_change_index", 0), 0, energyChange.length - 1
        );

        Optional<long[]> optional = view.getOptionalLongArray("energy_change");
        if (optional.isPresent() && optional.get().length == this.energyChange.length) {
            this.energyChange = optional.get();
        }
    }

    @Override
    protected void writeData(WriteView view) {
        view.put("powered_mode", StorageMode.CODEC, this.poweredMode);
        view.put("unpowered_mode", StorageMode.CODEC, this.unpoweredMode);
        view.putBoolean("is_powered", this.isPowered);
        view.putInt("energy_change_index", this.energyChangeIndex);
        view.putLongArray("energy_change", energyChange);

        this.energy.writeData(view);

        super.writeData(view);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayerEntity player) {
        return new BlockPosPayload(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return NAME;
    }

    @Override
    public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new EnergyStorageScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public void onInteraction(ServerPlayerEntity source, Identifier action, NbtCompound extraData) {
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
