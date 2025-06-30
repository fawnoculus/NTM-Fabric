package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.entities.SimpleEnergyStorageBE;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class SimpleEnergyStorageBlock extends BlockWithEntity {
  public SimpleEnergyStorageBlock(Settings settings) {
    super(settings);
  }
  
  private long MaxEnergy = 0;
  
  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return createCodec(SimpleEnergyStorageBlock::new);
  }
  
  @Override
  public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    SimpleEnergyStorageBE energyStorageBE = new SimpleEnergyStorageBE(pos, state);
    energyStorageBE.getNodeProperties().setMaxValue(this.MaxEnergy);
    return energyStorageBE;
  }
  
  public SimpleEnergyStorageBlock maxEnergy(long energy){
    this.MaxEnergy = energy;
    return this;
  }
}
