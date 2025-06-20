package net.fawnoculus.ntm.blocks.entities;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.item.InventoryStorage;
import net.fawnoculus.ntm.blocks.ModBlockEntities;
import net.fawnoculus.ntm.blocks.custom.AlloyFurnaceBlock;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.custom.BlockPosS2CPayload;
import net.fawnoculus.ntm.gui.handlers.AlloyFurnaceScreenHandler;
import net.fawnoculus.ntm.recipe.AlloyFurnaceRecipe;
import net.fawnoculus.ntm.recipe.AlloyFurnaceRecipeInput;
import net.fawnoculus.ntm.recipe.ModRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
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
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class AlloyFurnaceBE extends BlockEntity implements ExtendedScreenHandlerFactory<BlockPosS2CPayload> {
  public AlloyFurnaceBE(BlockPos pos, BlockState state) {
    super(ModBlockEntities.ALLOY_FURNACE_BE, pos, state);
  }
  
  // max fuel is consistent with original, but translated to fuel burn ticks for consistency
  private static final int MAX_FUEL = 102400;
  private static final int FUEL_PER_TICK = 8;
  private int fuel = 0;
  
  private static final int MAX_PROGESS = 400;
  private int progress = 0;
  
  private final SimpleInventory inventory = new SimpleInventory(4){
    @Override
    public void markDirty() {
      super.markDirty();
      update();
    }
  };
  
  public static final int OUTPUT_SLOT_INDEX = 0;
  public static final int FUEL_SLOT_INDEX = 1;
  public static final int INPUT_TOP_SLOT_INDEX = 2;
  public static final int INPUT_BOTTOM_SLOT_INDEX = 3;
  
  private final InventoryStorage inventoryStorage = InventoryStorage.of(inventory, null);
  
  @Override
  public void onBlockReplaced(BlockPos pos, BlockState oldState) {
    ItemScatterer.spawn(world, pos, inventory);
    super.onBlockReplaced(pos, oldState);
  }
  
  public static void tick(World world, BlockPos pos, BlockState state, AlloyFurnaceBE entity) {
    entity.processFuelInput();
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
    Optional<RecipeEntry<AlloyFurnaceRecipe>> recipe = getCurrentRecipe();
    return recipe.isPresent()
        && this.canInsertIntoSlot(recipe.get().value().output(), OUTPUT_SLOT_INDEX)
        && this.hasEnoughFuel();
  }
  
  private boolean hasEnoughFuel(){
    return fuel >= FUEL_PER_TICK;
  }
  
  private Optional<RecipeEntry<AlloyFurnaceRecipe>> getCurrentRecipe() {
    if(this.getWorld() instanceof ServerWorld serverWorld) {
      return serverWorld.getRecipeManager()
          .getFirstMatch(ModRecipes.ALLOY_FURNACE_RECIPE_TYPE, new AlloyFurnaceRecipeInput(inventory.getStack(INPUT_TOP_SLOT_INDEX), inventory.getStack(INPUT_BOTTOM_SLOT_INDEX)), serverWorld);
    }
    return Optional.empty();
  }
  
  public boolean canInsertIntoSlot(ItemStack stack, int slotIndex){
    ItemStack switchStack = this.inventory.getStack(slotIndex);
    if(switchStack.isEmpty()) return true;
    
    if(switchStack.getItem() == stack.getItem()){
      return switchStack.getCount() + stack.getCount() <= switchStack.getMaxCount();
    }
    
    return false;
  }
  
  public float getFuel(){
    return ((float) this.fuel) / ((float) MAX_FUEL);
  }
  
  public float getProgress(){
    return ((float) this.progress) / ((float) MAX_PROGESS);
  }
  
  public boolean showFireInGUI(){
    assert this.world != null;
    return this.world.getBlockState(this.pos).get(AlloyFurnaceBlock.LIT);
  }
  
  private boolean progressFinished(){
    return this.progress >= MAX_PROGESS;
  }
  
  private void craftOutput(){
    if(getCurrentRecipe().isEmpty()) throw new IllegalStateException();
    RecipeEntry<AlloyFurnaceRecipe> recipe = getCurrentRecipe().get();
    
    ItemStack recipeOutput = recipe.value().output().copy();
    recipeOutput.setCount(inventory.getStack(OUTPUT_SLOT_INDEX).getCount() + recipeOutput.getCount());
    
    inventory.setStack(OUTPUT_SLOT_INDEX, recipeOutput);
    
    inventory.removeStack(INPUT_BOTTOM_SLOT_INDEX, 1);
    inventory.removeStack(INPUT_TOP_SLOT_INDEX, 1);
  }
  
  private void addProgress(){
    this.fuel -= FUEL_PER_TICK;
    this.progress++;
    
    if(hasExtension()){
      this.progress++;
      this.progress++;
    }
    
    
    assert this.world != null;
    BlockState state = this.world.getBlockState(this.pos).with(AlloyFurnaceBlock.LIT, true);
    this.world.setBlockState(this.pos, state);
  }
  
  private void resetProgress(){
    this.progress = 0;
    
    assert this.world != null;
    if(!this.canCraft()){ // this is to avoid flickering
      BlockState state = this.world.getBlockState(this.pos).with(AlloyFurnaceBlock.LIT, false);
      this.world.setBlockState(this.pos, state);
    }
  }
  
  private void processFuelInput(){
    assert this.getWorld() != null;
    FuelRegistry fuelRegistry = this.getWorld().getFuelRegistry();
    ItemStack fuelStack = inventory.getStack(FUEL_SLOT_INDEX);
    if(!fuelRegistry.isFuel(fuelStack)) return;
    
    int fuelTicks = fuelRegistry.getFuelTicks(fuelStack);
    if(fuelTicks >= MAX_FUEL - this.fuel) return;
    this.fuel += fuelTicks;
    
    Item item = fuelStack.getItem();
    fuelStack.decrement(1);
    if (fuelStack.isEmpty()) {
      inventory.setStack(FUEL_SLOT_INDEX, item.getRecipeRemainder());
    }
  }
  
  private boolean hasExtension(){
    assert this.getWorld() != null;
    return this.getWorld().getBlockState(this.pos).get(AlloyFurnaceBlock.EXTENSION);
  }
  
  private void update(){
    markDirty();
    if(this.world != null) this.world.updateListeners(this.pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
  }
  
  public SimpleInventory getInventory(){
    return this.inventory;
  }
  
  @Override
  public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
    return new AlloyFurnaceScreenHandler(syncId, playerInventory, this);
  }
  
  @Override
  public BlockPosS2CPayload getScreenOpeningData(ServerPlayerEntity serverPlayerEntity) {
    return new BlockPosS2CPayload(this.pos);
  }
  
  @Override
  protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    nbt.putInt("fuel", fuel);
    nbt.putInt("process", progress);
    Inventories.writeNbt(nbt, this.inventory.getHeldStacks(), registryLookup);
    super.writeNbt(nbt, registryLookup);
  }
  
  @Override
  protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
    super.readNbt(nbt, registryLookup);
    Inventories.readNbt(nbt, this.inventory.getHeldStacks(), registryLookup);
    
    fuel = nbt.getInt("fuel").orElse(0);
    progress = nbt.getInt("process").orElse(0);
  }
  
  @Override
  public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
    return createNbt(registryLookup);
  }
  
  @Override
  public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
    return BlockEntityUpdateS2CPacket.create(this);
  }
  
  private static final Text DISPLAY_NAME = Text.translatable("container."+ NTM.MOD_ID+".alloy_furnace");
  @Override
  public Text getDisplayName() {
    return DISPLAY_NAME;
  }
}
