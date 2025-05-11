package net.fawnoculus.ntm.items.custom.tools;


import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface SpecialTool {
  
  SpecialTool addAbility(ItemAbility ability);
  SpecialTool addModifier(ItemModifier modifier);
  SpecialTool canBreakDepthRock();
  
  void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner);
}
