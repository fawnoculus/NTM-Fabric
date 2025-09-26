package net.fawnoculus.ntm.items.custom;

import net.fawnoculus.ntm.items.NTMDataComponentTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

import java.util.function.Consumer;

public class ConstructionWandItem extends Item {
  public ConstructionWandItem(Settings settings) {
    super(settings
      .component(NTMDataComponentTypes.BLOCK_POS_COMPONENT_TYPE, null)
      .component(NTMDataComponentTypes.BLOCK_STATE_COMPONENT_TYPE, Blocks.AIR.getDefaultState()));
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    if (context.getWorld().isClient()) {
      return ActionResult.SUCCESS;
    }
    assert context.getPlayer() != null;
    PlayerEntity player = context.getPlayer();
    assert context.getStack() != null;
    ItemStack stack = context.getStack();
    assert context.getWorld() != null;
    ServerWorld world = (ServerWorld) context.getWorld();

    if (player.isSneaking()) {
      stack.set(NTMDataComponentTypes.BLOCK_STATE_COMPONENT_TYPE, world.getBlockState(context.getBlockPos()));
      player.sendMessage(Text.translatable(
        "message.ntm.construction_wand.set_block",
        world.getBlockState(context.getBlockPos()).getBlock().getName()
      ), false);
      return ActionResult.SUCCESS_SERVER;
    }

    BlockPos selectedPos = getBlockPos(stack);
    if (selectedPos == null) {
      stack.set(NTMDataComponentTypes.BLOCK_POS_COMPONENT_TYPE, context.getBlockPos());
      player.sendMessage(Text.translatable(
        "message.ntm.construction_wand.set_pos",
        context.getBlockPos().getX(),
        context.getBlockPos().getY(),
        context.getBlockPos().getZ()
      ), false);
      return ActionResult.SUCCESS_SERVER;
    }

    int greaterX = Math.max(selectedPos.getX(), context.getBlockPos().getX());
    int lesserX = Math.min(selectedPos.getX(), context.getBlockPos().getX());
    int greaterY = Math.max(selectedPos.getY(), context.getBlockPos().getY());
    int lesserY = Math.min(selectedPos.getY(), context.getBlockPos().getY());
    int greaterZ = Math.max(selectedPos.getZ(), context.getBlockPos().getZ());
    int lesserZ = Math.min(selectedPos.getZ(), context.getBlockPos().getZ());
    int blocks = 0;

    for (int x = lesserX; x <= greaterX; x++) {
      for (int y = lesserY; y <= greaterY; y++) {
        for (int z = lesserZ; z <= greaterZ; z++) {
          world.setBlockState(new BlockPos(x, y, z), getBlockState(stack));
          blocks++;
        }
      }
    }
    stack.set(NTMDataComponentTypes.BLOCK_POS_COMPONENT_TYPE, null);
    player.sendMessage(Text.translatable("message.ntm.construction_wand.filled", blocks), false);
    return ActionResult.SUCCESS_SERVER;
  }

  private BlockState getBlockState(ItemStack stack) {
    return stack.getOrDefault(NTMDataComponentTypes.BLOCK_STATE_COMPONENT_TYPE, Blocks.AIR.getDefaultState());
  }

  private BlockPos getBlockPos(ItemStack stack) {
    return stack.getOrDefault(NTMDataComponentTypes.BLOCK_POS_COMPONENT_TYPE, null);
  }

  @Override
  @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip.ntm.creative_only").formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.construction_wand1").formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.construction_wand2").formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.construction_wand3").formatted(Formatting.GRAY));
    BlockPos pos = getBlockPos(stack);
    if (pos != null) {
      tooltip.accept(Text.translatable("tooltip.ntm.construction_wand.pos", pos.getX(), pos.getY(), pos.getZ()).formatted(Formatting.GRAY));
    } else {
      tooltip.accept(Text.translatable("tooltip.ntm.construction_wand.no_pos").formatted(Formatting.GRAY));
    }
    String blockIdentifier = Registries.BLOCK.getEntry(getBlockState(stack).getBlock()).getIdAsString();
    tooltip.accept(Text.translatable("tooltip.ntm.construction_wand.block", blockIdentifier).formatted(Formatting.GRAY));
  }
}
