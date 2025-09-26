package net.fawnoculus.ntm.api.multiblock;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

/**
 * A Record Containing all the BlockStates that in a specific Multiblock
 * @param states the BlockStates mapped by their offset from the multiblock origin
 */
public record MultiBlock(Map<BlockPos, BlockState> states) {
  public boolean canPlaceAt(World world, BlockPos originPos, Direction rotation) {
    for (BlockPos structurePos : states.keySet()) {
      BlockPos offsetPos = getOffsetPos(originPos, structurePos, rotation);
      if(!world.getBlockState(offsetPos).isReplaceable()){
        return false;
      }
    }

    return true;
  }

  public void placeAt(World world, BlockPos originPos, Direction rotation) {
    for (BlockPos structurePos : states.keySet()) {
      BlockPos offsetPos = getOffsetPos(originPos, structurePos, rotation);
      world.setBlockState(offsetPos, states.get(structurePos));
    }
  }

  /**
   * @param originPos the Position where the origin block was placed
   * @param structurePos the offset from the pos in the structure relative to the origin (in northwards rotation)
   * @param rotation the rotation in which the structure is placed
   * @return the position of the block in the rotated structure
   */
  @Contract("_, _, _ -> new")
  private static @NotNull BlockPos getOffsetPos(BlockPos originPos, BlockPos structurePos, @NotNull Direction rotation){
    boolean invertX = false;
    boolean invertY = false;
    boolean invertZ = false;

    boolean swapXY = false;
    boolean swapXZ = false;

    switch (rotation) {
      case NORTH -> {}
      case SOUTH -> invertX = true;
      case WEST -> swapXZ = true;
      case EAST -> {
        invertZ = true;
        swapXZ = true;
      }
      case UP -> swapXY = true;
      case DOWN -> {
        swapXY = true;
        invertY = true;
      }
    }

    int offsetX = invertX ? -structurePos.getX() : structurePos.getX();
    int offsetY = invertY ? -structurePos.getY() : structurePos.getY();
    int offsetZ = invertZ ? -structurePos.getZ() : structurePos.getZ();

    if(swapXY){
      int temp = offsetY;
      offsetY = offsetX;
      offsetX = temp;
    }

    if(swapXZ){
      int temp = offsetZ;
      offsetZ = offsetX;
      offsetX = temp;
    }

    return new BlockPos(originPos.getX() + offsetX, originPos.getY() + offsetY, originPos.getZ() + offsetZ);
  }
}
