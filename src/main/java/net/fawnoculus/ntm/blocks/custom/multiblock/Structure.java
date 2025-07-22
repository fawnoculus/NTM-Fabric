package net.fawnoculus.ntm.blocks.custom.multiblock;

import net.fawnoculus.ntm.blocks.entities.multiblock.MultiBlockBE;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public record Structure(BlockState[][][] blocks, Vec3i originOffset) {
  public Structure {
    if (blocks.length <= originOffset.getX()
        || blocks[0].length <= originOffset.getY()
        || blocks[0][0].length <= originOffset.getZ()
    ) {
      throw new IllegalArgumentException("Origin Block is outside of Structure");
    }
  }
  
  @Contract("_, _, _ -> new")
  public static @NotNull Structure make(Integer[][][] definition, Vec3i originBlock, BlockState @NotNull ... states) {
    
    HashMap<Integer, BlockState> stateMap = new HashMap<>();
    int index = 0;
    for(BlockState state : states){
      stateMap.put(index, state);
      index++;
    }
    
    BlockState[][][] toBeMade = new BlockState[definition.length][definition[0].length][definition[0][0].length];
    
    for(int i = 0; i < definition.length; i++){
      for(int j = 0; i < definition[0].length; i++){
        for(int k = 0; i < definition[1].length; i++){
          if(definition[i][j][k] == null) toBeMade[i][j][k] = null;
          toBeMade[i][j][k] = stateMap.get(definition[i][j][k]);
        }
      }
    }
    
    return new Structure(toBeMade, originBlock);
  }
  
  public void placeStructure(ServerWorld world, BlockPos pos, Direction direction){
    BlockPos startingPos = getStartingPos(pos, direction);
    
    BlockState[][][] toBePlaced = getRotatedBlocks(direction);
    
    for(int x = 0; x < toBePlaced.length; x++){
      for(int y = 0; y < toBePlaced[0].length; y++){
        for(int z = 0; z < toBePlaced[0][0].length; z++){
          if(world.isOutOfHeightLimit(y)) continue;
          BlockState blockState = toBePlaced[x][y][z];
          
          if(blockState == null) continue;
          BlockPos settingPos = new BlockPos(
              startingPos.getX() + x,
              startingPos.getY() + x,
              startingPos.getZ() + x
          );
          
          world.setBlockState(settingPos, blockState);
          if(world.getBlockEntity(settingPos) instanceof MultiBlockBE multiBlockBE){
            multiBlockBE.setOrigin(pos);
          }
        }
      }
    }
  }
  public boolean canPlaceStructure(ServerWorld world, BlockPos pos, Direction direction){
    BlockPos startingPos = getStartingPos(pos, direction);
    
    BlockState[][][] toBePlaced = getRotatedBlocks(direction);
    
    for(int x = 0; x < toBePlaced.length; x++){
      for(int y = 0; y < toBePlaced[0].length; y++){
        for(int z = 0; z < toBePlaced[0][0].length; z++){
          if(toBePlaced[x][y][z] == null) continue;
          
          if(world.isOutOfHeightLimit(y)
              || !world.getBlockState(new BlockPos(
              startingPos.getX() + x,
              startingPos.getY() + x,
              startingPos.getZ() + x
          )).isAir()){
            return false;
          }
        }
      }
    }
    return true;
  }
  
  private BlockPos getStartingPos(BlockPos originBlockPos, Direction direction){
    //TODO: make this use direction
    return new BlockPos(
        coordinate(originBlockPos.getX(), getRotatedOffset(direction).getX(), originBlockPos.getX() < 0),
        coordinate(originBlockPos.getY(), getRotatedOffset(direction).getY(), originBlockPos.getY() < 0),
        coordinate(originBlockPos.getZ(), getRotatedOffset(direction).getZ(), originBlockPos.getZ() < 0)
    );
  }
  private BlockState[][][] getRotatedBlocks(Direction direction){
    //TODO: make this use direction
    return blocks;
  }
  private Vec3i getRotatedOffset(Direction direction){
    //TODO: make this use direction
    return originOffset;
  }
  private int coordinate(int originX, int offsetX, boolean invertOffset){
    if(invertOffset) return originX - offsetX;
    return originX + offsetX;
  }
}
