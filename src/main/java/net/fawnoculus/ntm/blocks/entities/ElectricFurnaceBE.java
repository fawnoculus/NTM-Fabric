package net.fawnoculus.ntm.blocks.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.node.NodeProperties;
import net.fawnoculus.ntm.gui.handlers.ElectricFurnaceScreenHandler;
import net.fawnoculus.ntm.items.custom.container.energy.EnergyContainingItem;
import net.fawnoculus.ntm.network.custom.BlockPosS2CPayload;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.*;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.BuiltinRegistries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ElectricFurnaceBE extends AbstractEnergyInventoryBE implements ExtendedScreenHandlerFactory<BlockPosS2CPayload> {
  public ElectricFurnaceBE(BlockPos pos, BlockState state) {
    super(ModBlockEntities.ELECTRIC_FURNACE_BE, pos, state, NodeProperties.Consumer::new, 4);
  }
  public static final int OUTPUT_SLOT_INDEX = 0;
  public static final int INPUT_SLOT_INDEX = 1;
  public static final int BATTERY_SLOT_INDEX = 2;
  public static final int UPGRADE_SLOT_INDEX = 3;
  
  private static final Text DISPLAY_NAME = Text.translatable("container.ntm.electric_furnace");
  
  private double progress = 0;
  
  public static void tick(World world, BlockPos pos, BlockState state, ElectricFurnaceBE entity) {
    entity.processBattery();
    if(entity.canCraft()) {
      entity.addProgress();
      entity.update();
      if(entity.progressFinished()) {
        entity.craftOutput();
        entity.resetProgress();
        entity.update();
      }
      return;
    }
    entity.resetProgress();
    entity.update();
  }
  
  public boolean canCraft(){
    Optional<RecipeEntry<SmeltingRecipe>> recipe = getCurrentRecipe();
    return recipe.isPresent()
        && this.canInsertIntoSlot(recipe.get().value().craft(new SingleStackRecipeInput(getStack(INPUT_SLOT_INDEX)), BuiltinRegistries.createWrapperLookup()), OUTPUT_SLOT_INDEX)
        && this.hasEnoughEnergy();
  }
  
  private long energyPerTick(){
    return 5;
    
    // TODO: Power Saving & speed upgrades
  }
  
  private boolean hasEnoughEnergy(){
    return this.getNodeProperties().hasAtLeast(this.energyPerTick());
  }
  
  private void resetProgress(){
    this.progress = 0;
  }
  
  private void addProgress(){
    this.progress += 1;
    
    // TODO: Power Saving & speed upgrades
  }
  
  private boolean progressFinished(){
    Optional<RecipeEntry<SmeltingRecipe>> recipe = getCurrentRecipe();
    return recipe.filter(
        smeltingRecipeRecipeEntry -> this.progress >= smeltingRecipeRecipeEntry.value().getCookingTime()
    ).isPresent();
  }
  
  private void processBattery() {
    ItemStack stack = getStack(BATTERY_SLOT_INDEX);
    if(stack.getItem() instanceof EnergyContainingItem energyContainingItem){
      energyContainingItem.discharge(stack, this.getNodeProperties());
    }
  }
  
  private void craftOutput(){
    Optional<RecipeEntry<SmeltingRecipe>> optional = getCurrentRecipe();
    if(optional.isEmpty()) return;
    RecipeEntry<SmeltingRecipe> recipe = optional.get();
    
    ItemStack output = recipe.value().craft(new SingleStackRecipeInput(getStack(INPUT_SLOT_INDEX)), BuiltinRegistries.createWrapperLookup());
    output.setCount(output.getCount() + getStack(OUTPUT_SLOT_INDEX).getCount());
    setStack(OUTPUT_SLOT_INDEX, output);
    
    getStack(INPUT_SLOT_INDEX).decrement(1);
  }
  
  private Optional<RecipeEntry<SmeltingRecipe>> getCurrentRecipe() {
    if(this.getWorld() instanceof ServerWorld serverWorld) {
      return ServerRecipeManager.createCachedMatchGetter(RecipeType.SMELTING).getFirstMatch(new SingleStackRecipeInput(getStack(INPUT_SLOT_INDEX)), serverWorld);
    }
    return Optional.empty();
  }
  
  public boolean showFireInGUI() {
    return true;
  }
  
  public float getProgress() {
    Optional<RecipeEntry<SmeltingRecipe>> recipe = getCurrentRecipe();
    return recipe.map(smeltingRecipeRecipeEntry -> smeltingRecipeRecipeEntry.value().getCookingTime() / (float) this.progress).orElse(0F);
  }
  
  @Override
  public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new ElectricFurnaceScreenHandler(syncId, playerInventory, this);
  }
  
  @Override
  public BlockPosS2CPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
    return new BlockPosS2CPayload(this.pos);
  }
  
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    nbt.putDouble("process", progress);
    super.writeNbt(nbt, registryLookup);
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    progress = nbt.getDouble("process").orElse(0.0);
  }
  
  @Override
  public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
    return BlockEntityUpdateS2CPacket.create(this);
  }
  
  @Override
  public Text getDisplayName() {
    return DISPLAY_NAME;
  }
}
