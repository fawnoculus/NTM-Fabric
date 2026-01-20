package net.fawnoculus.ntm.blocks.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.gui.handlers.AlloyFurnaceScreenHandler;
import net.fawnoculus.ntm.network.s2c.BlockPosPayload;
import net.fawnoculus.ntm.recipe.NTMRecipes;
import net.fawnoculus.ntm.recipe.custom.AlloyFurnaceRecipe;
import net.fawnoculus.ntm.recipe.custom.AlloyFurnaceRecipeInput;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AlloyFurnaceBE extends AbstractInventoryBE implements ExtendedScreenHandlerFactory<BlockPosPayload> {
    public static final int OUTPUT_SLOT_INDEX = 0;
    public static final int FUEL_SLOT_INDEX = 1;
    public static final int INPUT_TOP_SLOT_INDEX = 2;
    public static final int INPUT_BOTTOM_SLOT_INDEX = 3;
    private static final int MAX_FUEL = 102400;
    private static final int FUEL_PER_TICK = 8;
    private static final int MAX_PROGESS = 400;
    private static final Component DISPLAY_NAME = Component.translatable("container.ntm.alloy_furnace");
    private int fuel = 0;
    private int progress = 0;

    public AlloyFurnaceBE(BlockPos pos, BlockState state) {
        super(NTMBlockEntities.ALLOY_FURNACE_BE, pos, state, 4);
    }

    public static void tick(Level ignored, BlockPos ignored2, BlockState ignored3, AlloyFurnaceBE entity) {
        entity.processFuelInput();
        if (entity.canCraft()) {
            entity.addProgress();
            if (entity.progressFinished()) {
                entity.craftOutput();
                entity.resetProgress();
            }
        } else {
            entity.resetProgress();
        }
        entity.setChanged();
    }

    public boolean canCraft() {
        Optional<RecipeHolder<AlloyFurnaceRecipe>> recipe = getCurrentRecipe();
        return recipe.isPresent()
          && this.canInsertIntoSlot(OUTPUT_SLOT_INDEX, recipe.get().value().output())
          && this.hasEnoughFuel();
    }

    private boolean hasEnoughFuel() {
        return fuel >= FUEL_PER_TICK;
    }

    private Optional<RecipeHolder<AlloyFurnaceRecipe>> getCurrentRecipe() {
        if (this.getLevel() instanceof ServerLevel serverWorld) {
            return serverWorld.recipeAccess()
              .getRecipeFor(NTMRecipes.ALLOY_FURNACE_RECIPE_TYPE, new AlloyFurnaceRecipeInput(this.getInventory().getItem(INPUT_TOP_SLOT_INDEX), this.getInventory().getItem(INPUT_BOTTOM_SLOT_INDEX)), serverWorld);
        }
        return Optional.empty();
    }

    private boolean progressFinished() {
        return this.progress >= MAX_PROGESS;
    }

    private void craftOutput() {
        if (getCurrentRecipe().isEmpty()) throw new IllegalStateException();
        RecipeHolder<AlloyFurnaceRecipe> recipe = getCurrentRecipe().get();

        ItemStack recipeOutput = recipe.value().output().copy();
        recipeOutput.setCount(this.getInventory().getItem(OUTPUT_SLOT_INDEX).getCount() + recipeOutput.getCount());

        this.getInventory().setItem(OUTPUT_SLOT_INDEX, recipeOutput);

        this.getInventory().removeItem(INPUT_BOTTOM_SLOT_INDEX, 1);
        this.getInventory().removeItem(INPUT_TOP_SLOT_INDEX, 1);
    }

    private void addProgress() {
        this.fuel -= FUEL_PER_TICK;
        this.progress++;

        if (hasExtension()) {
            this.progress++;
            this.progress++;
        }

        if (this.level != null) {
            BlockState state = this.level.getBlockState(this.worldPosition).setValue(AlloyFurnaceBlock.LIT, true);
            this.level.setBlockAndUpdate(this.worldPosition, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;

        if (this.level != null && !this.canCraft()) { // this is to avoid flickering
            BlockState state = this.level.getBlockState(this.worldPosition).setValue(AlloyFurnaceBlock.LIT, false);
            this.level.setBlockAndUpdate(this.worldPosition, state);
        }
    }

    private void processFuelInput() {
        assert this.getLevel() != null;
        FuelValues fuelRegistry = this.getLevel().fuelValues();
        ItemStack fuelStack = this.getInventory().getItem(FUEL_SLOT_INDEX);
        if (!fuelRegistry.isFuel(fuelStack)) return;

        int fuelTicks = fuelRegistry.burnDuration(fuelStack);
        if (fuelTicks >= MAX_FUEL - this.fuel) return;
        this.fuel += fuelTicks;

        Item item = fuelStack.getItem();
        fuelStack.shrink(1);
        if (fuelStack.isEmpty()) {
            this.getInventory().setItem(FUEL_SLOT_INDEX, item.getCraftingRemainder());
        }
    }

    private boolean hasExtension() {
        assert this.getLevel() != null;
        return this.getLevel().getBlockState(this.worldPosition).getValue(AlloyFurnaceBlock.EXTENSION);
    }

    @Override
    protected void loadAdditional(ValueInput view) {
        super.loadAdditional(view);
        fuel = view.getIntOr("fuel", 0);
        progress = view.getIntOr("process", 0);
    }

    @Override
    protected void saveAdditional(ValueOutput view) {
        view.putInt("fuel", fuel);
        view.putInt("process", progress);
        super.saveAdditional(view);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public double getFuel() {
        return (double) this.fuel / (double) MAX_FUEL;
    }

    public double getProgress() {
        return (double) this.progress / (double) MAX_PROGESS;
    }

    public boolean showFireInGUI() {
        if (this.level == null) return false;
        return this.level.getBlockState(this.worldPosition).getValue(AlloyFurnaceBlock.LIT);
    }

    @Override
    public Component getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int syncId, Inventory playerInventory, Player player) {
        return new AlloyFurnaceScreenHandler(syncId, playerInventory, this);
    }

    @Override
    public BlockPosPayload getScreenOpeningData(ServerPlayer serverPlayerEntity) {
        return new BlockPosPayload(this.worldPosition);
    }
}
