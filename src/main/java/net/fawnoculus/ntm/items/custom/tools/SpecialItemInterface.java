package net.fawnoculus.ntm.items.custom.tools;


import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface SpecialItemInterface {
  
  SpecialItemInterface addAbility(ItemAbility ability);
  SpecialItemInterface addModifier(ItemModifier modifier);
  SpecialItemInterface canBreakDepthRock();
  
  void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner);
}
