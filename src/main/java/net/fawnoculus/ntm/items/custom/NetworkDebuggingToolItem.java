package net.fawnoculus.ntm.items.custom;

import net.fawnoculus.ntm.blocks.node.Node;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
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

import java.util.function.Consumer;

public class NetworkDebuggingToolItem extends Item {
  public NetworkDebuggingToolItem(Settings settings) {
    super(settings);
  }
  
  @Override
  public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> tooltip, TooltipType type) {
    tooltip.accept(Text.translatable("tooltip.ntm.creative_only").formatted(Formatting.GRAY));
    tooltip.accept(Text.translatable("tooltip.ntm.network_debug_tool1").formatted(Formatting.RED));
    tooltip.accept(Text.translatable("tooltip.ntm.network_debug_tool2").formatted(Formatting.RED));
  }
  
  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    if (context.getWorld().isClient()) {
      return ActionResult.SUCCESS;
    }
    ServerWorld world = (ServerWorld) context.getWorld();
    assert world != null;
    BlockPos pos = context.getBlockPos();
    assert pos != null;
    PlayerEntity player = context.getPlayer();
    assert player != null;
    
    if (!(world.getBlockEntity(pos) instanceof Node<?> node)) {
      player.sendMessage(Text.translatable("message.ntm.network_debug.no_node").formatted(Formatting.RED), false);
      return ActionResult.SUCCESS_SERVER;
    }
    NodeNetwork<?> network = node.getNetwork();
    if(network == null){
      player.sendMessage(Text.translatable("message.ntm.network_debug.no_network").formatted(Formatting.RED), false);
      return ActionResult.SUCCESS_SERVER;
    }
    
    player.sendMessage(Text.translatable("message.ntm.network_debug.network_name", network.ID), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.network_type", network.getClass()), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_connector_count", network.LOADED_CONNECTORS.size()), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_consumer_count", network.LOADED_CONSUMERS), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_provider_count", network.LOADED_PROVIDERS.size()), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_storage_count", network.LOADED_STORAGES.size()), false);
    
    return ActionResult.SUCCESS_SERVER;
  }
}
