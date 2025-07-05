package net.fawnoculus.ntm.items.custom;

import net.fawnoculus.ntm.blocks.node.Node;
import net.fawnoculus.ntm.blocks.node.network.EnergyNetwork;
import net.fawnoculus.ntm.blocks.node.network.FluidNetwork;
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
    tooltip.accept(Text.translatable("tooltip.ntm.creative_only").formatted(Formatting.WHITE));
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
      player.sendMessage(Text.translatable("message.ntm.network_debug.not_node").formatted(Formatting.RED), false);
      return ActionResult.SUCCESS_SERVER;
    }
    NodeNetwork<?> network = node.getNetwork();
    if(network == null){
      player.sendMessage(Text.translatable("message.ntm.network_debug.node_no_network").formatted(Formatting.RED), false);
      return ActionResult.SUCCESS_SERVER;
    }
    
    if(player.isSneaking()){
      for(Node<?> a : node.getNetwork().LOADED_CONNECTORS){
        player.sendMessage(Text.literal("CONEC: " + a.getPos().toShortString()), false);
      }
      for(Node<?> a : node.getNetwork().LOADED_CONSUMERS){
        player.sendMessage(Text.literal("CONSO: " + a.getPos().toShortString()), false);
      }
      for(Node<?> a : node.getNetwork().LOADED_PROVIDERS){
        player.sendMessage(Text.literal("PROVI: " + a.getPos().toShortString()), false);
      }
      for(Node<?> a : node.getNetwork().LOADED_STORAGES){
        player.sendMessage(Text.literal("STORA: " + a.getPos().toShortString()), false);
      }
      return ActionResult.SUCCESS_SERVER;
    }
    
    player.sendMessage(Text.translatable("message.ntm.network_debug.network_name", Text.literal(network.ID.toString()).formatted(Formatting.WHITE)).formatted(Formatting.GOLD), false);
    switch (network){
      case EnergyNetwork ignored -> player.sendMessage(Text.translatable("message.ntm.network_debug.network_type", Text.translatable("message.ntm.network_debug.network_type.energy").formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
      case FluidNetwork ignored -> player.sendMessage(Text.translatable("message.ntm.network_debug.network_type", Text.translatable("message.ntm.network_debug.network_type.fluid").formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
      default -> player.sendMessage(Text.translatable("message.ntm.network_debug.network_type", Text.translatable("message.ntm.network_debug.network_type.unknown").formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    }
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_connector_count", Text.literal(String.valueOf(network.LOADED_CONNECTORS.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_consumer_count", Text.literal(String.valueOf(network.LOADED_CONSUMERS.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_provider_count", Text.literal(String.valueOf(network.LOADED_PROVIDERS.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    player.sendMessage(Text.translatable("message.ntm.network_debug.loaded_storage_count", Text.literal(String.valueOf(network.LOADED_STORAGES.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    
    return ActionResult.SUCCESS_SERVER;
  }
}
