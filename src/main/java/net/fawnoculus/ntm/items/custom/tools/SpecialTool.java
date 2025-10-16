package net.fawnoculus.ntm.items.custom.tools;


import net.fawnoculus.ntm.NTM;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public interface SpecialTool {
  Identifier ADVANCED_MESSAGE_ID = NTM.id("tool_ability");

  AbilityHandler getAbilities();

  ModifierHandler getModifiers();

  boolean getCanBreakDepthRock();

  void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner);
}
