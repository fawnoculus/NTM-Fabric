package net.fawnoculus.ntm.blocks.custom;

import com.mojang.serialization.MapCodec;
import net.fawnoculus.ntm.blocks.entities.EnergyConnectorBE;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.Nullable;

public class TempCableBlock extends BlockWithEntity {
  public TempCableBlock(Settings settings) {
    super(settings);
  }
  
  @Override
  protected MapCodec<? extends BlockWithEntity> getCodec() {
    return createCodec(TempCableBlock::new);
  }
  
  @Override
  public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
    return new EnergyConnectorBE(pos, state);
  }
}
