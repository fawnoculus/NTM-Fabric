package net.fawnoculus.ntm.items.custom.tools;

import net.fawnoculus.ntm.items.ModItems;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Abilities {
  // Abilities that can be used are bellow
  /**
   * VeinMiner causes all blocks of the same type as the one broken to be mined
   * <p>
   * MaxBlocks is the max Distance that a block can have from the originally broken block before it will no longer be harvested by VeinMiner
   */
  public static class VeinMiner implements ItemAbility {
    public VeinMiner(int MaxBlocks) {
      this.MaxBlocks = MaxBlocks;
    }
    
    public final Integer MaxBlocks;
    
    @Override
    public String getTranslationKey() {
      return "tooltip.ntm.ability.veinminer";
    }
    
    @Override
    public String getValue() {
      return this.MaxBlocks.toString();
    }
    
    private final List<Block> excludedBlocks = List.of(Blocks.STONE, Blocks.NETHERRACK);
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      if (!isCorrectForDrops(stack, state)) {
        return;
      }
      
      //TODO: make this work
      Block compareBlock = state.getBlock();
      
      if (excludedBlocks.contains(compareBlock)) {
        return;
      }
      
      List<BlockPos> allBlocks = new ArrayList<>();
      List<BlockPos> toBeScannedBlocks = new ArrayList<>();
      int previousSize = 0;
      allBlocks.add(pos);
      toBeScannedBlocks.add(pos);
      
      BlockPos comparedPos;
      NTM.LOGGER.info("AllBlocks Initial: " + allBlocks);
      NTM.LOGGER.info("Scanning Blocks Initial: " + toBeScannedBlocks);
      
      while (allBlocks.size() != previousSize) {
        for (BlockPos blockpos : toBeScannedBlocks) {
          comparedPos = blockpos.north();
          if ((!allBlocks.contains(comparedPos)) && world.getBlockState(comparedPos).getBlock() == compareBlock) {
            allBlocks.add(comparedPos);
            toBeScannedBlocks.add(comparedPos);
          }
          comparedPos = blockpos.east();
          if ((!allBlocks.contains(comparedPos)) && world.getBlockState(comparedPos).getBlock() == compareBlock) {
            allBlocks.add(comparedPos);
            toBeScannedBlocks.add(comparedPos);
          }
          comparedPos = blockpos.south();
          if ((!allBlocks.contains(comparedPos)) && world.getBlockState(comparedPos).getBlock() == compareBlock) {
            allBlocks.add(comparedPos);
            toBeScannedBlocks.add(comparedPos);
          }
          comparedPos = blockpos.west();
          if ((!allBlocks.contains(comparedPos)) && world.getBlockState(comparedPos).getBlock() == compareBlock) {
            allBlocks.add(comparedPos);
            toBeScannedBlocks.add(comparedPos);
          }
          comparedPos = blockpos.up();
          if ((!allBlocks.contains(comparedPos)) && world.getBlockState(comparedPos).getBlock() == compareBlock) {
            allBlocks.add(comparedPos);
            toBeScannedBlocks.add(comparedPos);
          }
          comparedPos = blockpos.down();
          if ((!allBlocks.contains(comparedPos)) && world.getBlockState(comparedPos).getBlock() == compareBlock) {
            allBlocks.add(comparedPos);
            toBeScannedBlocks.add(comparedPos);
          }
          toBeScannedBlocks.remove(blockpos);
          NTM.LOGGER.info("BlockSet: " + allBlocks);
          NTM.LOGGER.info("Scanning Blocks: " + toBeScannedBlocks);
        }
      }
    }
  }
  /**
   * AoE breaks a cube around the block broken by the player
   * <p>
   * blockAmount decides how big the Cube is (Value of 1 would cause a 3x3 Cube, Value of 2 a 5x5 Cube and so on)
   */
  public static class AoE implements ItemAbility {
    public AoE(int blockAmount){
      this.blockAmount = blockAmount;
    }
    public final Integer blockAmount;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.aoe";}
    @Override
    public String getValue() {return this.blockAmount.toString();}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      if(isCorrectForDrops(stack, state)){
        
        for (int x = pos.getX()-this.blockAmount; x <= pos.getX()+this.blockAmount; x++) {
          for (int y = pos.getY()-this.blockAmount; y <= pos.getY()+this.blockAmount; y++) {
            for (int z = pos.getZ()-this.blockAmount; z <= pos.getZ()+this.blockAmount; z++) {
              
              BlockState checkBlock = world.getBlockState(new BlockPos(x, y, z));
              
              if(isCorrectForDrops(stack, checkBlock)){
                world.breakBlock(new BlockPos(x, y, z), true, miner);
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
    public String getValue() {return null;}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      //TODO: this
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
    public String getValue() {return null;}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      //TODO: this
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
    public String getValue() {return null;}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      //TODO: this
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
    public String getValue() {return null;}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      //TODO: this
    }
  }
  /**
   * It's the same thing as if you had the enchantment
   */
  public static class SilkTouch implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.silktouch";}
    @Override
    public String getValue() {return null;}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      //TODO: this
    }
  }
  /**
   * It's the same thing as if you had the enchantment
   * <p>
   * The Level represents the Enchantment Level of Fortune that will be applied
   */
  public static class Fortune implements ItemAbility {
    public Fortune(int level){
      this.level = level;
    }
    public final Integer level;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.fortune";}
    @Override
    public String getValue() {return this.level.toString();}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      //TODO: this
    }
  }
  /**
   * Creates an explosion when a block that the tool can be used for is broken
   * <p>
   * The resulting Explosion has the Strength specified by "explosionStrength"
   */
  public static class Explosion implements ItemAbility {
    public Explosion(float explosionStrength){
      this.explosionStrength = explosionStrength;
    }
    public final Float explosionStrength;
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.explosion";}
    @Override
    public String getValue() {return this.explosionStrength.toString();}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      if(!isCorrectForDrops(stack, state)){return;}
      //TODO: this
    }
  }
  /**
   * Makes redstone blocks & ores drop a random amount of mercury drops
   */
  public static class MercuryTouch implements ItemAbility {
    @Override
    public String getTranslationKey() {return "tooltip.ntm.ability.mercurytouch";}
    @Override
    public String getValue() {return null;}
    
    @Override
    public void postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
      
      int mercury = 0;
      if(state.getBlock() == Blocks.REDSTONE_ORE || state.getBlock() == Blocks.DEEPSLATE_REDSTONE_ORE)
        mercury = miner.getRandom().nextInt(5) + 4;
      if(state.getBlock() == Blocks.REDSTONE_BLOCK)
        mercury = miner.getRandom().nextInt(7) + 8;
      
      if(mercury > 0) {
        world.breakBlock(pos, false);
        world.spawnEntity(new ItemEntity(world, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, new ItemStack(ModItems.NULL, mercury))); //TODO: replace this with Mercury Drops once they are implemented
        try {
          stack.damage(1, (PlayerEntity) miner);
        }catch (ClassCastException exception){
          NTM.LOGGER.warn("WTF: \n" + exception);
        }
      }
    }
  }
  
  // Copied from net.minecraft.item.Item
  private static boolean isCorrectForDrops(ItemStack stack, BlockState state) {
    ToolComponent toolComponent = stack.get(DataComponentTypes.TOOL);
    return toolComponent != null && toolComponent.isCorrectForDrops(state);
  }
}