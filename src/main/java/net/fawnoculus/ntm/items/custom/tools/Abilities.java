package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.NTMItems;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.util.EnchantmentUtil;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.explosion.AdvancedExplosionBehavior;
import net.minecraft.world.explosion.ExplosionBehavior;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Abilities {
  /**
     * VeinMiner causes all blocks of the same type as the one broken to be mined
     * <p>
     * MaxBlocks is the max Distance that a block can have from the originally broken block before it will no longer be harvested by VeinMiner
     */
    public record VeinMiner(Integer MaxDistance) implements ItemAbility {
      @Override
      public String getTranslationKey() {
        return "tooltip.ntm.ability.veinminer";
      }

      @Override
      public @NotNull String getValue() {
        return this.MaxDistance.toString();
      }

      @Override
      public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
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
          scanNeighbours(world, compareBlock, pos, pos, scannedBlocks);
        } catch (StackOverflowError ignored) {
        }

        for (BlockPos breakingPos : scannedBlocks) {
          world.breakBlock(breakingPos, !miner.isCreative(), miner);
        }

      }

    // These updates the List scannedBlocks
      private void scanNeighbours(World world, Block compareBlock, BlockPos originPos, BlockPos scanningPos, List<BlockPos> scannedBlocks) {
        scanBlock(world, compareBlock, originPos, scanningPos.up(), scannedBlocks);
        scanBlock(world, compareBlock, originPos, scanningPos.down(), scannedBlocks);
        scanBlock(world, compareBlock, originPos, scanningPos.north(), scannedBlocks);
        scanBlock(world, compareBlock, originPos, scanningPos.east(), scannedBlocks);
        scanBlock(world, compareBlock, originPos, scanningPos.south(), scannedBlocks);
        scanBlock(world, compareBlock, originPos, scanningPos.west(), scannedBlocks);
      }

    private void scanBlock(World world, Block compareBlock, BlockPos originPos, BlockPos scanningPos, List<BlockPos> scannedBlocks) {
        if (scannedBlocks.contains(scanningPos)) return;
        if (world.getBlockState(scanningPos).getBlock() != compareBlock) return;
        if (!originPos.isWithinDistance(scanningPos, this.MaxDistance)) return;
        scannedBlocks.add(scanningPos);
        scanNeighbours(world, compareBlock, originPos, scanningPos, scannedBlocks);
      }
    }

  /**
     * AoE breaks a cube around the block broken by the player
     * <p>
     * blockAmount decides how big the Cube is (Value of 1 would cause a 3x3 Cube, Value of 2 a 5x5 Cube and so on)
     */
    public record AoE(Integer blockAmount) implements ItemAbility {
    @Override
      public String getTranslationKey() {
      return "tooltip.ntm.ability.aoe";
    }

    @Override
      public @NotNull String getValue() {
      return this.blockAmount.toString();
    }

      @Override
      public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
        //Update the exclusion List every time the ability is used, just in case
        List<Block> excludedBlocks = new ArrayList<>();
        for (String id : NTMConfig.AoeAbilityExclude.getValue()) {
          excludedBlocks.add(Registries.BLOCK.get(Identifier.of(id)));
        }

        if (isCorrectForDrops(stack, state) && !excludedBlocks.contains(state.getBlock())) {

          for (int x = pos.getX() - this.blockAmount; x <= pos.getX() + this.blockAmount; x++) {
            for (int y = pos.getY() - this.blockAmount; y <= pos.getY() + this.blockAmount; y++) {
              for (int z = pos.getZ() - this.blockAmount; z <= pos.getZ() + this.blockAmount; z++) {

                BlockState checkBlock = world.getBlockState(new BlockPos(x, y, z));

                if (isCorrectForDrops(stack, checkBlock) && !excludedBlocks.contains(checkBlock.getBlock())) {
                  world.breakBlock(new BlockPos(x, y, z), !miner.isCreative(), miner);
                }
              }
            }
          }
        }
      }
    }
  /**
   * Makes blocks drop what the thing they dropped would have produced when smelted
   * If the drop doesn't have a smelting recipe it will the regular drop will be used instead
   */
  public static class AutoSmelt implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.autosmelt";}
    @Override
    public @Nullable String getValue() {return null;}

    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
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

      world.breakBlock(pos, false, miner);
    }
  }
  /**
   * Makes blocks drop what the thing they dropped would have produced when shredded
   * If the drop doesn't have a shredding recipe it will the regular drop will be used instead
   */
  public static class AutoShreader implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.autoshreader";}
    @Override
    public @Nullable String getValue() {return null;}

    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
      //TODO: Do this once you have Shreader Recipes
    }
  }
  /**
   * Makes blocks drop what the thing they dropped would have produced when centrifuged
   * If the drop doesn't have a centrifuging recipe it will the regular drop will be used instead
   */
  public static class AutoCentrifuge implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.autocentrifuge";}
    @Override
    public @Nullable String getValue() {return null;}

    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
      //TODO: Do this once you have Centrifuge Recipes
    }
  }
  /**
   * Makes blocks drop what the thing they dropped would have produced when Crystallized (aka: put in an Ore Acidizer)
   * If the drop doesn't have a Crystallizing recipe it will the regular drop will be used instead
   */
  public static class AutoCrystallizer implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.autocrystallizer";}
    @Override
    public @Nullable String getValue() {return null;}

    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
      //TODO: Do this once you have Crystallizer Recipes
    }
  }
  /**
   * It's the same thing as if you had the enchantment
   */
  public static class SilkTouch implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.silktouch";}
    @Override
    public @Nullable String getValue() {return null;}

    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
      if(miner.isCreative()){
        return;
      }
      if(EnchantmentUtil.hasEnchantment(world, Enchantments.SILK_TOUCH, stack)){
        return;
      }
      EnchantmentUtil.addEnchantment(world, Enchantments.SILK_TOUCH, 1, stack);
      world.breakBlock(pos, true, miner);
      EnchantmentUtil.removeEnchantment(world, Enchantments.SILK_TOUCH, stack);
    }
  }

  /**
     * It's the same thing as if you had the enchantment
     * <p>
     * The Level represents the Enchantment Level of Fortune that will be applied
     */
    public record Fortune(Integer level) implements ItemAbility {
    @Override
      public String getTranslationKey() {
      return "tooltip.ntm.ability.fortune";
    }

    @Override
      public @NotNull String getValue() {
      return this.level.toString();
    }

      @Override
      public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
        if (miner.isCreative()) {
          return;
        }
        if (EnchantmentUtil.hasEnchantment(world, Enchantments.FORTUNE, stack)) {
          return;
        }
        EnchantmentUtil.addEnchantment(world, Enchantments.FORTUNE, level, stack);
        world.breakBlock(pos, true, miner);
        EnchantmentUtil.removeEnchantment(world, Enchantments.FORTUNE, stack);
      }
    }

  /**
     * Creates an explosion when a block that the tool can be used for is broken
     * <p>
     * The resulting Explosion has the Strength specified by "explosionStrength"
     */
    public record Explosion(Float explosionStrength) implements ItemAbility {
    @Override
      public String getTranslationKey() {
      return "tooltip.ntm.ability.explosion";
    }

    @Override
      public @NotNull String getValue() {
      return this.explosionStrength.toString();
    }

      @Override
      public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
        if (!isCorrectForDrops(stack, state)) return;
        ExplosionBehavior explosionBehavior = new AdvancedExplosionBehavior(true, false, Optional.empty(), Optional.empty());
        world.createExplosion(null, null, explosionBehavior, Vec3d.of(pos), explosionStrength, false, World.ExplosionSourceType.TNT);
      }
    }
  /**
   * Makes redstone blocks & ores drop a random amount of mercury drops
   */
  public static class MercuryTouch implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.mercurytouch";}
    @Override
    public @Nullable String getValue() {return null;}

    @Override
    public void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner) {
      if(miner.isCreative()){
        return;
      }

      int mercury = 0;
      if(state.getBlock() == Blocks.REDSTONE_ORE || state.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE)
        mercury = miner.getRandom().nextInt(5) + 4;
      if(state.getBlock() == Blocks.REDSTONE_BLOCK)
        mercury = miner.getRandom().nextInt(7) + 8;

      if(mercury > 0) {
        world.breakBlock(pos, false);
        ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(NTMItems.NULL, mercury)); //TODO: replace this with Mercury Drops once they exist

        stack.damage(1, miner);
      }
    }
  }

  private static boolean isCorrectForDrops(ItemStack stack, BlockState state) {
    ToolComponent toolComponent = stack.get(DataComponentTypes.TOOL);
    return toolComponent != null && toolComponent.isCorrectForDrops(state);
  }
}
