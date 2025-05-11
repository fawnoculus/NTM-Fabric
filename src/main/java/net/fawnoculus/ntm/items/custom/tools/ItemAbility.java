package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * An Empty Interface
 * <p>
 * Everything that implements this is an ItemAbility
 * <p>
 * All Abilities can be found at {@link Abilities}
 */
public interface ItemAbility {
  String getTranslationKey();
  String getValue();
  void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner);
}
