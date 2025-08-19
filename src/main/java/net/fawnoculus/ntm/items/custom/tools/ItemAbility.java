package net.fawnoculus.ntm.items.custom.tools;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * An Empty Interface
 * <p>
 * Everything that implements this is an ItemAbility
 * <p>
 * All Abilities can be found at {@link Abilities}
 */
public interface ItemAbility {
  default MutableText getFullName(){
    if(this.getValue() != null){
      return Text.translatable(this.getTranslationKey()).append(Text.literal(" ("+ this.getValue() +")"));
    }
    return Text.translatable(this.getTranslationKey());
  }
  String getTranslationKey();
  @Nullable String getValue();
  void preMine(ItemStack stack, World world, BlockState state, BlockPos pos, PlayerEntity miner);
}
