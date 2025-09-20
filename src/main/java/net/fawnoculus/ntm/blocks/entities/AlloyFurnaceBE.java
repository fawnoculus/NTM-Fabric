package net.fawnoculus.ntm.blocks.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.network.s2c.BlockPosPayload;
import net.fawnoculus.ntm.gui.handlers.AlloyFurnaceScreenHandler;
import net.fawnoculus.ntm.recipe.custom.AlloyFurnaceRecipe;
import net.fawnoculus.ntm.recipe.custom.AlloyFurnaceRecipeInput;
import net.fawnoculus.ntm.recipe.NTMRecipes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AlloyFurnaceBE extends AbstractInventoryBE implements ExtendedScreenHandlerFactory<BlockPosPayload> {
  public AlloyFurnaceBE(BlockPos pos, BlockState state) {
    super(NTMBlockEntities.ALLOY_FURNACE_BE, pos, state, 4);
  }

  private static final int MAX_FUEL = 102400;
  private static final int FUEL_PER_TICK = 8;
  private int fuel = 0;

  private static final int MAX_PROGESS = 400;
  private int progress = 0;

  public static final int OUTPUT_SLOT_INDEX = 0;
  public static final int FUEL_SLOT_INDEX = 1;
  public static final int INPUT_TOP_SLOT_INDEX = 2;
  public static final int INPUT_BOTTOM_SLOT_INDEX = 3;

  private static final Text DISPLAY_NAME = Text.translatable("container.ntm.alloy_furnace");

  public static void tick(World world, BlockPos pos, BlockState state, AlloyFurnaceBE entity) {
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
    entity.markDirty();
  }

  public boolean canCraft() {
    Optional<RecipeEntry<AlloyFurnaceRecipe>> recipe = getCurrentRecipe();
    return recipe.isPresent()
      && this.canInsertIntoSlot(OUTPUT_SLOT_INDEX, recipe.get().value().output())
      && this.hasEnoughFuel();
  }

  private boolean hasEnoughFuel() {
    return fuel >= FUEL_PER_TICK;
  }

  private Optional<RecipeEntry<AlloyFurnaceRecipe>> getCurrentRecipe() {
    if (this.getWorld() instanceof ServerWorld serverWorld) {
      return serverWorld.getRecipeManager()
        .getFirstMatch(NTMRecipes.ALLOY_FURNACE_RECIPE_TYPE, new AlloyFurnaceRecipeInput(this.getInventory().getStack(INPUT_TOP_SLOT_INDEX), this.getInventory().getStack(INPUT_BOTTOM_SLOT_INDEX)), serverWorld);
    }
    return Optional.empty();
  }

  private boolean progressFinished() {
    return this.progress >= MAX_PROGESS;
  }

  private void craftOutput() {
    if (getCurrentRecipe().isEmpty()) throw new IllegalStateException();
    RecipeEntry<AlloyFurnaceRecipe> recipe = getCurrentRecipe().get();

    ItemStack recipeOutput = recipe.value().output().copy();
    recipeOutput.setCount(this.getInventory().getStack(OUTPUT_SLOT_INDEX).getCount() + recipeOutput.getCount());

    this.getInventory().setStack(OUTPUT_SLOT_INDEX, recipeOutput);

    this.getInventory().removeStack(INPUT_BOTTOM_SLOT_INDEX, 1);
    this.getInventory().removeStack(INPUT_TOP_SLOT_INDEX, 1);
  }

  private void addProgress() {
    this.fuel -= FUEL_PER_TICK;
    this.progress++;

    if (hasExtension()) {
      this.progress++;
      this.progress++;
    }

    if (this.world != null) {
      BlockState state = this.world.getBlockState(this.pos).with(AlloyFurnaceBlock.LIT, true);
      this.world.setBlockState(this.pos, state);
    }
  }

  private void resetProgress() {
    this.progress = 0;

    if (this.world != null && !this.canCraft()) { // this is to avoid flickering
      BlockState state = this.world.getBlockState(this.pos).with(AlloyFurnaceBlock.LIT, false);
      this.world.setBlockState(this.pos, state);
    }
  }

  private void processFuelInput() {
    assert this.getWorld() != null;
    FuelRegistry fuelRegistry = this.getWorld().getFuelRegistry();
    ItemStack fuelStack = this.getInventory().getStack(FUEL_SLOT_INDEX);
    if (!fuelRegistry.isFuel(fuelStack)) return;

    int fuelTicks = fuelRegistry.getFuelTicks(fuelStack);
    if (fuelTicks >= MAX_FUEL - this.fuel) return;
    this.fuel += fuelTicks;

    Item item = fuelStack.getItem();
    fuelStack.decrement(1);
    if (fuelStack.isEmpty()) {
      this.getInventory().setStack(FUEL_SLOT_INDEX, item.getRecipeRemainder());
    }
  }

  private boolean hasExtension() {
    assert this.getWorld() != null;
    return this.getWorld().getBlockState(this.pos).get(AlloyFurnaceBlock.EXTENSION);
  }

  @Override
  protected void readData(ReadView view) {
    super.readData(view);
    fuel = view.getInt("fuel", 0);
    progress = view.getInt("process", 0);
  }

  @Override
  protected void writeData(WriteView view) {
    view.putInt("fuel", fuel);
    view.putInt("process", progress);
    super.writeData(view);
  }

  @Override
  public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
    return BlockEntityUpdateS2CPacket.create(this);
  }

  public double getFuel() {
    return (double) this.fuel / (double) MAX_FUEL;
  }

  public double getProgress() {
    return (double) this.progress / (double) MAX_PROGESS;
  }

  public boolean showFireInGUI() {
    if (this.world == null) return false;
    return this.world.getBlockState(this.pos).get(AlloyFurnaceBlock.LIT);
  }

  @Override
  public Text getDisplayName() {
    return DISPLAY_NAME;
  }

  @Override
  public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new AlloyFurnaceScreenHandler(syncId, playerInventory, this);
  }

  @Override
  public BlockPosPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
    return new BlockPosPayload(this.pos);
  }
}
