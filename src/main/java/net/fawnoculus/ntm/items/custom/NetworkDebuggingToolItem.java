package net.fawnoculus.ntm.items.custom;

import net.fawnoculus.ntm.api.node.Node;
import net.fawnoculus.ntm.api.node.NodeValueContainer;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.function.Consumer;

public class NetworkDebuggingToolItem extends Item {
  public NetworkDebuggingToolItem(Settings settings) {
    super(settings);
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    if (context.getWorld().isClient()) {
      return ActionResult.SUCCESS;
    }
    ServerWorld world = (ServerWorld) context.getWorld();
    BlockPos pos = context.getBlockPos();
    PlayerEntity player = context.getPlayer();

    if (player == null) {
      // how
      return ActionResult.FAIL;
    }

    if (!(world.getBlockEntity(pos) instanceof Node clickedNode)) {
      player.sendMessage(Text.translatable("message.ntm.network_debug.not_node").formatted(Formatting.RED), false);
      return ActionResult.SUCCESS_SERVER;
    }
    NodeNetwork network = clickedNode.getNetwork();
    if (network == null) {
      player.sendMessage(Text.translatable("message.ntm.network_debug.node_no_network").formatted(Formatting.RED), false);
      return ActionResult.SUCCESS_SERVER;
    }

    player.sendMessage(Text.translatable("message.ntm.network_debug.network_name", Text.literal(network.ID.toString()).formatted(Formatting.WHITE)).formatted(Formatting.GOLD), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.network_type", network.TYPE.getName().formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.node_count", Text.literal(String.valueOf(network.LOADED_NODES.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.provider_count", Text.literal(String.valueOf(getProviderCount(network))).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.provider_priorities", Text.literal(network.REVERSED_PROVIDER_PRIORITIES.toString()).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.consumer_count", Text.literal(String.valueOf(getConsumerCount(network))).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.consumer_priorities", Text.literal(network.REVERSED_CONSUMER_PRIORITIES.toString()).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);

    return ActionResult.SUCCESS_SERVER;
  }

  private static long getConsumerCount(NodeNetwork network) {
    long consumers = 0;
    for (List<NodeValueContainer> containers : network.PRIORITISED_CONSUMERS.values()) {
      consumers += containers.size();
    }
    return consumers;
  }

  private static long getProviderCount(NodeNetwork network) {
    long providers = 0;
    for (List<NodeValueContainer> containers : network.PRIORITISED_PROVIDERS.values()) {
      providers += containers.size();
    }
    return providers;
  }

  @Override
  @SuppressWarnings("deprecation")
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip.ntm.creative_only").formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.network_debug_tool1").formatted(Formatting.RED));
    tooltip.accept(Text.translatable("tooltip.ntm.network_debug_tool2").formatted(Formatting.RED));
  }
}
