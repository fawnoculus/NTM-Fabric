package net.fawnoculus.ntm.api.tool;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.util.EnchantmentUtil;
import net.fawnoculus.ntm.util.WorldUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootWorldContext;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
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
  public static final ItemAbility VEIN_MINER = new ItemAbility(NTM.id("vein_miner"), 10, false) {
    @Override
    public MutableText getLevelText(@Range(from = 0, to = 10) int level) {
      return Text.literal("(" + (level + 2) + ")");
    }

    @Override
    public void addExtraBlocks(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level, ArrayList<BlockPos> extraBlocks) {
      if (!isCorrectForDrops(stack, state)) {
        return;
      }
      Block compareBlock = state.getBlock();

      if (NTMConfig.VEIN_MINER_ABILITY_EXCLUDE.getValue().contains(compareBlock)) {
        return;
      }

      extraBlocks.add(pos);
      try {
        scanNeighbours(world, compareBlock, pos, pos, extraBlocks, level);
      } catch (StackOverflowError ignored) {
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
      scanNeighbours(world, compareBlock, originPos, scanningPos, scannedBlocks,  level);
    }
  };

  /**
     * AoE breaks a cube around the block broken by the player
     * <p>
     * blockAmount decides how big the Cube is (Value of 1 would cause a 3x3 Cube, Value of 2 a 5x5 Cube and so on)
     */
  public static final ItemAbility AOE = new ItemAbility(NTM.id("aoe"), 10, false) {
    @Override
    public void addExtraBlocks(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level, ArrayList<BlockPos> extraBlocks) {
      if (!isCorrectForDrops(stack, state) || NTMConfig.AOE_ABILITY_EXCLUDE.getValue().contains(state.getBlock())) {
        return;
      }

      for (int x = pos.getX() - level; x <= pos.getX() + level; x++) {
        for (int y = pos.getY() - level; y <= pos.getY() + level; y++) {
          for (int z = pos.getZ() - level; z <= pos.getZ() + level; z++) {
            BlockState checkBlock = world.getBlockState(new BlockPos(x, y, z));

            if (isCorrectForDrops(stack, checkBlock) && !NTMConfig.AOE_ABILITY_EXCLUDE.getValue().contains(checkBlock.getBlock())) {
              extraBlocks.add(new BlockPos(x, y, z));
            }
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
  public static final ItemAbility FLAT_AOE = new ItemAbility(NTM.id("flat_aoe"), 10, false) {
    @Override
    public void addExtraBlocks(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level, ArrayList<BlockPos> extraBlocks) {
      if (!isCorrectForDrops(stack, state) || NTMConfig.AOE_ABILITY_EXCLUDE.getValue().contains(state.getBlock())) {
        return;
      }

      if(!(miner.raycast(miner.getAttributeValue(EntityAttributes.BLOCK_INTERACTION_RANGE), 1, false) instanceof BlockHitResult hitResult)) return;

      int xRange = level;
      int yRange = level;
      int zRange = 0;

      switch (hitResult.getSide()) {
        case WEST, EAST -> {
          xRange = 0;
          zRange = level;
        }
        case UP, DOWN -> {
          yRange = 0;
          zRange = level;
        }
      }



      for (int x = pos.getX() - xRange; x <= pos.getX() + xRange; x++) {
        for (int y = pos.getY() - yRange; y <= pos.getY() + yRange; y++) {
          for (int z = pos.getZ() - zRange; z <= pos.getZ() + zRange; z++) {
            BlockState checkBlock = world.getBlockState(new BlockPos(x, y, z));

            if (isCorrectForDrops(stack, checkBlock) && !NTMConfig.AOE_ABILITY_EXCLUDE.getValue().contains(checkBlock.getBlock())) {
              extraBlocks.add(new BlockPos(x, y, z));
            }
          }
        }
      }
    }
  };

  /**
   * Creates an explosion when a block that the tool can be used for is broken
   * <p>
   * The resulting EXPLOSION has the Strength specified by "explosionStrength"
   */
  public static final ItemAbility EXPLOSION = new ItemAbility(NTM.id("explosion"), 10, false, true) {
    @Override
    public MutableText getLevelText(@Range(from = 0, to = 10) int level) {
      if (level < 2) {
        return Text.literal("(2.5)");
      }

      return Text.literal("(" + 5 * (level - 1) + ".0)");
    }

    private float fromLevel(int level) {
      if (level < 2) {
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
   * It's the same thing as if you had the enchantment
   */
  public static final ItemAbility SILK_TOUCH = new ItemAbility(NTM.id("silk_touch"), true){
    @Override
    public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      BlockState state = world.getBlockState(pos);

      if (!isCorrectForDrops(stack, state)) {
        return true;
      }

      if (miner.shouldSkipBlockDrops()) {
        return false;
      }

      EnchantmentUtil.addEnchantment(world, Enchantments.SILK_TOUCH, 1, stack);
      WorldUtil.dropItemsFromBlock(world, pos, miner, stack);
      EnchantmentUtil.removeEnchantment(world, Enchantments.SILK_TOUCH, stack);
      return false;
    }
  };

  /**
   * It's the same thing as if you had the enchantment
   * <p>
   * The Level represents the Enchantment Level of FORTUNE that will be applied
   */
  public static final ItemAbility FORTUNE = new ItemAbility(NTM.id("fortune"), 10, true) {
    @Override
    public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      BlockState state = world.getBlockState(pos);

      if (!isCorrectForDrops(stack, state)) {
        return true;
      }

      if (miner.shouldSkipBlockDrops()) {
        return false;
      }

      EnchantmentUtil.addEnchantment(world, Enchantments.FORTUNE, level, stack);
      WorldUtil.dropItemsFromBlock(world, pos, miner, stack);
      EnchantmentUtil.removeEnchantment(world, Enchantments.FORTUNE, stack);
      return false;
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when smelted
   * If the drop doesn't have a smelting recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AUTO_SMELT = new ItemAbility(NTM.id("auto_smelt"), true) {
    @Override
    public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      BlockState state = world.getBlockState(pos);

      if(!isCorrectForDrops(stack, state) || !(world instanceof ServerWorld serverWorld)){
        return true;
      }

      if(miner.shouldSkipBlockDrops()){
        return false;
      }

      LootWorldContext.Builder builder = new LootWorldContext.Builder(serverWorld)
        .add(LootContextParameters.ORIGIN, Vec3d.ofCenter(pos))
        .add(LootContextParameters.BLOCK_STATE, state)
        .addOptional(LootContextParameters.BLOCK_ENTITY, world.getBlockEntity(pos))
        .addOptional(LootContextParameters.THIS_ENTITY, miner)
        .add(LootContextParameters.TOOL, stack);

      List<ItemStack> list = state.getDroppedStacks(builder);
      for (ItemStack checkedStack : list) {
        SingleStackRecipeInput recipeInput = new SingleStackRecipeInput(checkedStack);

        Optional<RecipeEntry<SmeltingRecipe>> optional = ServerRecipeManager.createCachedMatchGetter(RecipeType.SMELTING).getFirstMatch(recipeInput, serverWorld);
        if (optional.isEmpty()) {
          continue;
        }

        RecipeEntry<SmeltingRecipe> recipeEntry = optional.get();

        ItemStack output = recipeEntry.value().craft(recipeInput, serverWorld.getRegistryManager());
        output.setCount(checkedStack.getCount());

        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), output);
      }

      return false;
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when shredded
   * If the drop doesn't have a shredding recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AUTO_SHREADER = new ItemAbility(NTM.id("auto_shredder"), true) {
    @Override
    public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      BlockState state = world.getBlockState(pos);

      if(!isCorrectForDrops(stack, state) || !(world instanceof ServerWorld serverWorld)){
        return true;
      }

      if(miner.shouldSkipBlockDrops()){
        return false;
      }

      //TODO: Do this once you have Shreader Recipes
      return super.onBreakBlock(stack, world, pos, miner, level);
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when centrifuged
   * If the drop doesn't have a centrifuging recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AUTO_CENTRIFUGE = new ItemAbility(NTM.id("auto_centrifuge"), true) {
    @Override
    public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      BlockState state = world.getBlockState(pos);

      if(!isCorrectForDrops(stack, state) || !(world instanceof ServerWorld serverWorld)){
        return true;
      }

      if(miner.shouldSkipBlockDrops()){
        return false;
      }

      //TODO: Do this once you have Centrifuge Recipes
      return super.onBreakBlock(stack, world, pos, miner, level);
    }
  };

  /**
   * Makes blocks drop what the thing they dropped would have produced when Crystallized (aka: put in an Ore Acidizer)
   * If the drop doesn't have a Crystallizing recipe it will the regular drop will be used instead
   */
  public static final ItemAbility AUTO_CRYSTALLIZER = new ItemAbility(NTM.id("auto_crystallizer"), true) {
    @Override
    public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      BlockState state = world.getBlockState(pos);

      if(!isCorrectForDrops(stack, state) || !(world instanceof ServerWorld serverWorld)){
        return true;
      }

      if(miner.shouldSkipBlockDrops()){
        return false;
      }

      //TODO: Do this once you have Crystallizer Recipes
      return super.onBreakBlock(stack, world, pos, miner, level);
    }
  };

  /**
   * Makes redstone blocks &AMP; ores drop a random amount of mercury drops
   */
  public static final ItemAbility MERCURY_TOUCH = new ItemAbility(NTM.id("mercury_touch"), true) {
    @Override
    public boolean onBreakBlock(ItemStack stack, World world, BlockPos pos, PlayerEntity miner, @Range(from = 0, to = 10) int level) {
      BlockState state = world.getBlockState(pos);

      int mercury = 0;
      if (state.getBlock() == Blocks.REDSTONE_ORE || state.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE)
        mercury = miner.getRandom().nextInt(5) + 4;
      if (state.getBlock() == Blocks.REDSTONE_BLOCK)
        mercury = miner.getRandom().nextInt(7) + 8;

      if (mercury > 0) {
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(NTMItems.NULL, mercury)); //TODO: replace this with Mercury Drops once they exist
        stack.damage(1, miner);

        return false;
      }

      return true;
    }
  };

  private static boolean isCorrectForDrops(ItemStack stack, BlockState state) {
    ToolComponent toolComponent = stack.get(DataComponentTypes.TOOL);
    return toolComponent != null && toolComponent.isCorrectForDrops(state);
  }
}
