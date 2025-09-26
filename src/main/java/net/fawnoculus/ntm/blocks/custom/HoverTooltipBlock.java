package net.fawnoculus.ntm.blocks.custom;

import net.minecraft.block.BlockState;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public interface HoverTooltipBlock {
  default boolean shouldDisplayTooltip(World world, BlockPos pos, BlockState state) {
    return true;
  }

  default List<Text> getTooltip(World world, BlockPos pos, BlockState state) {
    List<Text> tooltip = new ArrayList<>();
    try {
      this.appendHoverTooltip(world, pos, state, tooltip::add);
    } catch (Throwable throwable) {
      tooltip.add(Text.translatable("error.ntm.while.block_hover_tooltip").formatted(Formatting.RED));
      tooltip.add(Text.translatable("error.ntm.exception", Text.literal(throwable.toString()).formatted(Formatting.YELLOW)).formatted(Formatting.RED));
    }

    return tooltip;
  }

  /**
   * You can throw Exceptions in here, it will be handled without crashing the game
   */
  void appendHoverTooltip(World world, BlockPos pos, BlockState state, Consumer<Text> tooltip);
}
