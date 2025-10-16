package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.util.EnchantmentUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.Range;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Abilities {
  /**
     * VeinMiner causes all blocks of the same type as the one broken to be mined
     * <p>
     * MaxBlocks is the max Distance that a block can have from the originally broken block before it will no longer be harvested by VeinMiner
     */
  public static final ItemAbility VEIN_MINER = new ItemAbility(NTM.id("vein_miner"), false) {
    @Override
    public MutableText getLevelText(@Range(from = 0, to = 10) int level) {
      return Text.literal("(" + (level + 2) + ")");
    }

    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      if (!isCorrectForDrops(stack, state)) {
        return;
      }
      Block compareBlock = state.getBlock();

      //Update the exclusion List every time the ability is used, just in case
      List<Block> excludedBlocks = new ArrayList<>();
      for (String id : NTMConfig.VeinMinerAbilityExclude.getValue()) {
        excludedBlocks.add(Registries.BLOCK.get(Identifier.of(id)));
      }

      if (excludedBlocks.contains(compareBlock)) {
        return;
      }

      List<BlockPos> scannedBlocks = new ArrayList<>();
      scannedBlocks.add(pos);
      try {
        scanNeighbours(world, compareBlock, pos, pos, scannedBlocks, level);
      } catch (StackOverflowError ignored) {
      }

      for (BlockPos breakingPos : scannedBlocks) {
        breakBlock(world, breakingPos, miner, !miner.shouldSkipBlockDrops());
      }
    }

    // These updates the List scannedBlocks
    private void scanNeighbours(World world, Block compareBlock, BlockPos originPos, BlockPos scanningPos, List<BlockPos> scannedBlocks, @Range(from = 0, to = 10) int level) {
      scanBlock(world, compareBlock, originPos, scanningPos.up(), scannedBlocks, level);
      scanBlock(world, compareBlock, originPos, scanningPos.down(), scannedBlocks, level);
      scanBlock(world, compareBlock, originPos, scanningPos.north(), scannedBlocks, level);
      scanBlock(world, compareBlock, originPos, scanningPos.east(), scannedBlocks, level);
      scanBlock(world, compareBlock, originPos, scanningPos.south(), scannedBlocks, level);
      scanBlock(world, compareBlock, originPos, scanningPos.west(), scannedBlocks, level);
    }

    private void scanBlock(World world, Block compareBlock, BlockPos originPos, BlockPos scanningPos, List<BlockPos> scannedBlocks, @Range(from = 0, to = 10) int level) {
      if (scannedBlocks.contains(scanningPos)) return;
      if (world.getBlockState(scanningPos).getBlock() != compareBlock) return;
      if (!originPos.isWithinDistance(scanningPos, level + 2)) return;
      scannedBlocks.add(scanningPos);
      scanNeighbours(world, compareBlock, originPos, scanningPos, scannedBlocks, + 3);
    }
  };

  /**
     * AoE breaks a cube around the block broken by the player
     * <p>
     * blockAmount decides how big the Cube is (Value of 1 would cause a 3x3 Cube, Value of 2 a 5x5 Cube and so on)
     */
  public static final ItemAbility AOE = new ItemAbility(NTM.id("aoe"), false) {
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      //Update the exclusion List every time the ability is used, just in case
      List<Block> excludedBlocks = new ArrayList<>();
      for (String id : NTMConfig.AoeAbilityExclude.getValue()) {
        excludedBlocks.add(Registries.BLOCK.get(Identifier.of(id)));
      }

      if (!isCorrectForDrops(stack, state) || excludedBlocks.contains(state.getBlock())) {
        return;
      }
      boolean swapXZ = false;
      boolean swapYZ = false;

      switch (miner.getFacing()) {
        case WEST, EAST -> swapXZ = true;
        case UP, DOWN -> swapYZ = true;
      }

      for (int x = pos.getX() - level; x <= pos.getX() + level; x++) {
        for (int y = pos.getY() - level; y <= pos.getY() + level; y++) {
          int targetX = x;
          int targetY = y;
          int targetZ = pos.getZ();

          if(swapXZ){
            int temp = targetZ;
            targetZ = targetX;
            targetX = temp;
          }

          if(swapYZ){
            int temp = targetZ;
            targetZ = targetY;
            targetY = temp;
          }

          BlockState checkBlock = world.getBlockState(new BlockPos(targetX, targetY, targetZ));

          if (isCorrectForDrops(stack, checkBlock) && !excludedBlocks.contains(checkBlock.getBlock())) {
            breakBlock(world, new BlockPos(targetX, targetY, targetZ), miner, !miner.shouldSkipBlockDrops());
          }
        }
      }
    }
  };

  /**
   * AoE breaks a cube around the block broken by the player
   * <p>
   * blockAmount decides how big the Cube is (Value of 1 would cause a 3x3 Cube, Value of 2 a 5x5 Cube and so on)
   */
  public static final ItemAbility FLAT_AOE = new ItemAbility(NTM.id("flat_aoe"), false) {
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      //Update the exclusion List every time the ability is used, just in case
      List<Block> excludedBlocks = new ArrayList<>();
      for (String id : NTMConfig.AoeAbilityExclude.getValue()) {
        excludedBlocks.add(Registries.BLOCK.get(Identifier.of(id)));
      }

      if (!isCorrectForDrops(stack, state) || excludedBlocks.contains(state.getBlock())) {
        return;
      }

      for (int x = pos.getX() - level; x <= pos.getX() + level; x++) {
        for (int y = pos.getY() - level; y <= pos.getY() + level; y++) {
          for (int z = pos.getZ() - level; z <= pos.getZ() + level; z++) {

            BlockState checkBlock = world.getBlockState(new BlockPos(x, y, z));

            if (isCorrectForDrops(stack, checkBlock) && !excludedBlocks.contains(checkBlock.getBlock())) {
              breakBlock(world, new BlockPos(x, y, z), miner, !miner.shouldSkipBlockDrops());
            }
          }
        }
      }
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when smelted
   * If the drop doesn't have a smelting recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AutoSmelt = new ItemAbility(NTM.id("auto_smelt"), true){
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      if(miner.isCreative()) return;
      if(!isCorrectForDrops(stack, state)) return;
      if(!(world instanceof ServerWorld serverWorld)) return;

      LootWorldContext.Builder builder = new LootWorldContext.Builder(serverWorld)
          .add(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos))
          .add(LootContextParameters.BLOCK_STATE, state)
          .addOptional(LootContextParameters.BLOCK_ENTITY, world.getBlockEntity(pos))
          .addOptional(LootContextParameters.THIS_ENTITY, miner)
          .add(LootContextParameters.TOOL, stack);

      List<ItemStack> list = state.getDroppedStacks(builder);
      for(ItemStack checkedStack : list){
        SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(checkedStack);

        Optional<RecipeEntry<SmeltingRecipe>> optional = ServerRecipeManager.createCachedMatchGetter(RecipeType.SMELTING).getFirstMatch(recipeInput, serverWorld);
        if(optional.isEmpty()) return;

        RecipeEntry<SmeltingRecipe> recipeEntry = optional.get();

        ItemStack output = recipeEntry.value().craft(recipeInput, serverWorld.getRegistryManager());
        output.setCount(checkedStack.getCount());

        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), output);
      }

      breakBlock(world, pos, miner, false);
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when shredded
   * If the drop doesn't have a shredding recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AutoShredder = new ItemAbility(NTM.id("auto_shredder"), true){
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      //TODO: Do this once you have Shreader Recipes
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when centrifuged
   * If the drop doesn't have a centrifuging recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AutoCentrifuge = new ItemAbility(NTM.id("auto_centrifuge"), true){
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      //TODO: Do this once you have Centrifuge Recipes
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when Crystallized (aka: put in an Ore Acidizer)
   * If the drop doesn't have a Crystallizing recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AutoCrystallizer = new ItemAbility(NTM.id("auto_crystallizer"), true){
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      //TODO: Do this once you have Crystallizer Recipes
    }
  };

  /**
   * It's the same thing as if you had the enchantment
   */
  public static final ItemAbility SilkTouch = new ItemAbility(NTM.id("silk_touch"), true){
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      if(miner.isCreative()){
        return;
      }
      EnchantmentUtil.addEnchantment(world, Enchantments.SILK_TOUCH, 1, stack);
    }

    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      EnchantmentUtil.removeEnchantment(world, Enchantments.SILK_TOUCH, stack);
      super.postMine(stack, world, state, pos, miner, level);
    }
  };

  /**
     * It's the same thing as if you had the enchantment
     * <p>
     * The Level represents the Enchantment Level of Fortune that will be applied
     */
  public static final ItemAbility Fortune = new ItemAbility(NTM.id("fortune"), true) {
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      if (miner.isCreative()) {
        return;
      }
      EnchantmentUtil.addEnchantment(world, Enchantments.FORTUNE, level, stack);
    }

    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      EnchantmentUtil.removeEnchantment(world, Enchantments.FORTUNE, stack);
      super.postMine(stack, world, state, pos, miner, level);
    }
  };

  /**
     * Creates an explosion when a block that the tool can be used for is broken
     * <p>
     * The resulting Explosion has the Strength specified by "explosionStrength"
     */
  public static final ItemAbility Explosion = new ItemAbility(NTM.id("explosion"), false) {
    @Override
    public MutableText getLevelText(@Range(from = 0, to = 10) int level) {
      if(level < 2){
        return Text.literal("(2.5)");
      }

      return Text.literal("(" + 5 * (level - 1) + ".0)");
    }

    private float fromLevel(int level){
      if(level < 2){
        return 2.5f;
      }

      return 5f * (level - 1);
    }

    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      if (!isCorrectForDrops(stack, state)) return;
      ExplosionBehavior explosionBehavior = new AdvancedExplosionBehavior(true, false, Optional.empty(), Optional.empty());
      world.createExplosion(null, null, explosionBehavior, Vec3d.of(pos), this.fromLevel(level), false, World.ExplosionSourceType.TNT);
    }
  };

  /**
   * Makes redstone blocks &AMP; ores drop a random amount of mercury drops
   */
  public static final ItemAbility MercuryTouch = new ItemAbility(NTM.id("mercury_touch"), true){
    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      if(miner.isCreative()){
        return;
      }

      int mercury = 0;
      if(state.getBlock() == Blocks.REDSTONE_ORE || state.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE)
        mercury = miner.getRandom().nextInt(5) + 4;
      if(state.getBlock() == Blocks.REDSTONE_BLOCK)
        mercury = miner.getRandom().nextInt(7) + 8;

      if(mercury > 0) {
        breakBlock(world, pos, miner, false);
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(NTMItems.NULL, mercury)); //TODO: replace this with Mercury Drops once they exist

        stack.damage(1, miner);
      }
    }
  };

  private static boolean isCorrectForDrops(ItemStack stack, BlockState state) {
    ToolComponent toolComponent = stack.get(DataComponentTypes.TOOL);
    return toolComponent != null && toolComponent.isCorrectForDrops(state);
  }

  private static void breakBlock(World world, BlockPos pos, PlayerEntity player, boolean doBlockDrops){
    BlockEntity blockEntity = world.getBlockEntity(pos);
    BlockState originalState = world.getBlockState(pos);
    Block block = originalState.getBlock();
    BlockState newState = block.onBreak(world, pos, originalState, player);
    boolean bl = world.removeBlock(pos, false);
    if (bl) {
      block.onBroken(world, pos, newState);
    }

    if (doBlockDrops) {
      ItemStack itemStack = player.getMainHandStack();
      ItemStack itemStack2 = itemStack.copy();
      boolean bl2 = player.canHarvest(newState);
      itemStack.postMine(world, newState, pos, player);
      if (bl && bl2) {
        block.afterBreak(world, player, pos, newState, blockEntity, itemStack2);
      }
    }
  }
}
