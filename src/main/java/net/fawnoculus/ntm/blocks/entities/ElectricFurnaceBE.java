package net.fawnoculus.ntm.blocks.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fawnoculus.ntm.blocks.NTMBlockEntities;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.blocks.custom.ElectricFurnaceBlock;
import net.fawnoculus.ntm.blocks.entities.container.energy.EnergyInventoryBE;
import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.fawnoculus.ntm.gui.handlers.ElectricFurnaceScreenHandler;
import net.fawnoculus.ntm.items.custom.container.energy.EnergyContainingItem;
import net.fawnoculus.ntm.misc.stack.EnergyStack;
import net.fawnoculus.ntm.network.s2c.BlockPosPayload;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ElectricFurnaceBE extends EnergyInventoryBE implements ExtendedScreenHandlerFactory<BlockPosPayload> {
  public static final Text NAME = Text.translatable("container.ntm.electric_furnace");

  public static final int OUTPUT_SLOT_INDEX = 0;
  public static final int INPUT_SLOT_INDEX = 1;
  public static final int BATTERY_SLOT_INDEX = 2;
  public static final int UPGRADE_SLOT_INDEX = 3;

  public ElectricFurnaceBE(BlockPos pos, BlockState state) {
    super(NTMBlockEntities.ELECTRIC_FURNACE_BE, pos, state, 4);
    this.propertyDelegate = new PropertyDelegate() {
      @Override
      public int get(int index) {
        return switch (index) {
          case 0 -> (int) progress;
          case 1 -> getRequiredProgress();
          default -> 0;
        };
      }

      @Override
      public void set(int index, int value) {
        if (index == 0) {
          progress = value;
        }
      }

      @Override
      public int size() {
        return 2;
      }
    };
  }

  public final EnergyStack energy = new EnergyStack(this).setMaxValue(100_000).setConsumes(true).onChange(this::markDirty);

  private final PropertyDelegate propertyDelegate;
  private double progress = 0;

  public static void tick(World world, BlockPos pos, BlockState state, ElectricFurnaceBE entity) {
    entity.processBattery();
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

  private Optional<RecipeEntry<SmeltingRecipe>> getRecipe() {
    if (!(this.world instanceof ServerWorld serverWorld)) {
      return Optional.empty();
    }
    SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(getStack(INPUT_SLOT_INDEX));
    return ServerRecipeManager.createCachedMatchGetter(RecipeType.SMELTING).getFirstMatch(recipeInput, serverWorld);
  }

  private int getRequiredProgress() {
    return this.getRecipe()
      .map(recipeEntry -> recipeEntry.value().getCookingTime())
      .orElse(0);
  }

  private double getProgressPerTick() {
    // TODO: upgrades People, Upgrades
    return 1;
  }

  private long getEnergyPerTick() {
    // TODO: upgrades People, Upgrades
    return 50;
  }

  private void craftOutput() {
    Optional<RecipeEntry<SmeltingRecipe>> optional = this.getRecipe();
    if (optional.isEmpty()) return;

    RecipeEntry<SmeltingRecipe> recipe = optional.get();
    ItemStack output = recipe.value().craft(new SingleStackRecipeInput(getStack(INPUT_SLOT_INDEX)), BuiltinRegistries.createWrapperLookup());

    output.setCount(getStack(OUTPUT_SLOT_INDEX).getCount() + 1);
    setStack(OUTPUT_SLOT_INDEX, output);

    getStack(INPUT_SLOT_INDEX).decrement(1);
  }

  private boolean canCraft() {
    return this.energy.getValue() >= this.getEnergyPerTick()
      && this.getRecipe().isPresent()
      && canInsertIntoSlot(OUTPUT_SLOT_INDEX, this.getRecipe().get().value().craft(new SingleStackRecipeInput(getStack(INPUT_SLOT_INDEX)), BuiltinRegistries.createWrapperLookup()));
  }

  private boolean progressFinished() {
    return this.progress >= this.getRequiredProgress();
  }

  private void addProgress() {
    this.progress += this.getProgressPerTick();
    this.energy.remove(this.getEnergyPerTick());

    if (this.world != null) {
      BlockState state = this.world.getBlockState(this.pos).with(AlloyFurnaceBlock.LIT, true);
      this.world.setBlockState(this.pos, state);
    }
  }

  private void resetProgress() {
    this.progress = 0;

    if (this.world != null && !this.canCraft()) {
      BlockState state = this.world.getBlockState(this.pos).with(ElectricFurnaceBlock.LIT, false);
      this.world.setBlockState(this.pos, state);
    }
  }

  private void processBattery() {
    ItemStack stack = getStack(BATTERY_SLOT_INDEX);
    if (stack.getItem() instanceof EnergyContainingItem energyContainingItem) {
      energyContainingItem.discharge(stack, this.energy);
    }
  }

  @Override
  public Collection<NodeValueContainer> getContainers() {
    return List.of(this.energy);
  }

  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    nbt.putDouble("progress", this.progress);
    this.energy.writeNBT(nbt);
    super.writeNbt(nbt, registryLookup);
  }

  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    this.energy.readNBT(nbt);
    this.progress = nbt.getDouble("progress", 0);
  }

  public double getProgress(int requiredProgress) {
    return progress / requiredProgress;
  }

  public boolean showFireInGUI() {
    if (this.world == null) return false;
    return this.world.getBlockState(this.pos).get(AlloyFurnaceBlock.LIT);
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
    return new ElectricFurnaceScreenHandler(syncId, playerInventory, this, propertyDelegate);
  }
}
