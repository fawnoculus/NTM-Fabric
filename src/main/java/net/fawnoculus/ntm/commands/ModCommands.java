package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.blocks.node.network.EnergyNetwork;
import net.fawnoculus.ntm.blocks.node.network.FluidNetwork;
import net.fawnoculus.ntm.blocks.node.network.NodeNetwork;
import net.fawnoculus.ntm.blocks.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.main.NTMConfig;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveAllMessagesS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveMessageS2CPayload;
import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.command.argument.UuidArgumentType;
import net.minecraft.component.Component;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class ModCommands {
  public static void initialize() {
    
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
        CommandManager.literal("ntm")
            .then(CommandManager.literal("config")
                .requires(source -> allowCommands(source, environment)
                )
                .then(CommandManager.literal("server")
                )
                .then(CommandManager.literal("world")
                    .then(CommandManager.literal("default")
                    )
                )
                .then(CommandManager.literal("client")
                    .requires(ignored -> environment.integrated)
                )
            )
            .then(CommandManager.literal("version")
                .executes(context -> version(context, environment)
                )
            )
            .then(CommandManager.literal("message")
                .requires(source -> allowCommands(source, environment))
                .then(CommandManager.argument("targets", EntityArgumentType.players())
                    .then(CommandManager.literal("send")
                        .then(CommandManager.argument("text", TextArgumentType.text(registryAccess))
                            .executes(context ->
                                sendMessage(context,
                                    EntityArgumentType.getPlayers(context, "targets"),
                                    NTM.id("command_server"),
                                    context.getArgument("text", Text.class),
                                    2000.0f))
                            .then(CommandManager.argument("milliSeconds", FloatArgumentType.floatArg(0f, 10000f))
                                .executes(context ->
                                    sendMessage(context,
                                        EntityArgumentType.getPlayers(context, "targets"),
                                        NTM.id("command_server"),
                                        context.getArgument("text", Text.class),
                                        context.getArgument("milliSeconds", Float.class)
                                    ))
                                .then(CommandManager.argument("identifier", IdentifierArgumentType.identifier())
                                    .executes(context ->
                                        sendMessage(
                                            context,
                                            EntityArgumentType.getPlayers(context, "targets"),
                                            context.getArgument("identifier", Identifier.class),
                                            context.getArgument("text", Text.class),
                                            context.getArgument("milliSeconds", Float.class)
                                        ))
                                )
                            )
                        )
                    )
                    .then(CommandManager.literal("remove")
                        .then(CommandManager.argument("identifier", IdentifierArgumentType.identifier())
                            .executes(context -> removeMessage(context, EntityArgumentType.getPlayers(context, "targets"), context.getArgument("identifier", Identifier.class)))
                        )
                    )
                    .then(CommandManager.literal("remove_all")
                        .executes(context -> removeAllMessages(context, EntityArgumentType.getPlayers(context, "targets")))
                    )
                )
            )
            .then(CommandManager.literal("dev")
                .requires(source -> allowCommands(source, null)
                )
                .then(CommandManager.literal("list_components")
                    .executes(context -> getDataComponents(context, 100))
                    .then(CommandManager.argument("max_length", IntegerArgumentType.integer())
                        .executes(context -> getDataComponents(context, context.getArgument("max_length", Integer.class)))
                    )
                )
                .then(CommandManager.literal("clean_logs")
                    .executes(ModCommands::deleteLogs)
                )
                .then(CommandManager.literal("funny")
                    .executes(ModCommands::funny)
                )
                .then(CommandManager.literal("get_node_networks")
                    .executes(ModCommands::getNodeNetworks)
                )
                .then(CommandManager.literal("node_network_info")
                    .then(CommandManager.argument("uuid", UuidArgumentType.uuid())
                        .executes(context -> getNodeNetworkInfo(context, context.getArgument("uuid", UUID.class)))
                    )
                )
            )
    ));
  }
  
  private static boolean allowCommands(ServerCommandSource source, @Nullable CommandManager.RegistrationEnvironment environment){
    if(environment != null && environment.integrated) return true;
    return source.hasPermissionLevel(NTMConfig.RequiredCommandPermission.getValue());
  }
  
  private static int version(CommandContext<ServerCommandSource> context, CommandManager.RegistrationEnvironment environment){
    if(environment.dedicated) {
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.version.server", NTM.METADATA.getVersion()), false);
    }
    if(environment.integrated){
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.version", NTM.METADATA.getVersion()), false);
    }
    return 1;
  }
  
  private static int removeMessage(CommandContext<ServerCommandSource> context, Collection<ServerPlayerEntity> targets, Identifier identifier){
    for(ServerPlayerEntity player : targets){
      ServerPlayNetworking.send(player, new RemoveMessageS2CPayload(identifier));
    }
    if(identifier.toString().equals("special:all_messages")){
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.message.cleared_all", targets.size()), true);
    }else {
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.message.cleared_specific", identifier.toString(), targets.size()), true);
    }
    return 1;
  }
  
  private static int removeAllMessages(CommandContext<ServerCommandSource> context, Collection<ServerPlayerEntity> targets){
    for(ServerPlayerEntity player : targets){
      ServerPlayNetworking.send(player, new RemoveAllMessagesS2CPayload());
    }
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.message.cleared_all", targets.size()), true);
    return 1;
  }
  private static int sendMessage(CommandContext<ServerCommandSource> context, Collection<ServerPlayerEntity> targets, Identifier identifier, Text text, float millis){
    for(ServerPlayerEntity player : targets){
      ServerPlayNetworking.send(player, new AdvancedMessageS2CPayload(new AdvancedMessage(identifier, text, millis)));
    }
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.message.sent", targets.size()), true);
    return 1;
  }
  
  private static int funny(CommandContext<ServerCommandSource> context){
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.the_funny"), false);
    // This doesn't actually do anything
    return 1;
  }
  
  private static int getNodeNetworkInfo(CommandContext<ServerCommandSource> context, UUID networkID){
    NodeNetwork<?> network = NodeNetworkManager.getNetwork(networkID);
    if(network == null){
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.no_network").formatted(Formatting.RED), false);
      return -1;
    }
    
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.network_name", Text.literal(network.ID.toString()).formatted(Formatting.WHITE)).formatted(Formatting.GOLD), false);
    switch (network){
      case EnergyNetwork ignored -> context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.network_type", Text.translatable("message.ntm.network_debug.network_type.energy").formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
      case FluidNetwork ignored -> context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.network_type", Text.translatable("message.ntm.network_debug.network_type.fluid").formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
      default -> context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.network_type", Text.translatable("message.ntm.network_debug.network_type.unknown").formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    }
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.loaded_connector_count", Text.literal(String.valueOf(network.LOADED_CONNECTORS.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.loaded_consumer_count", Text.literal(String.valueOf(network.LOADED_CONSUMERS.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.loaded_provider_count", Text.literal(String.valueOf(network.LOADED_PROVIDERS.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.loaded_storage_count", Text.literal(String.valueOf(network.LOADED_STORAGES.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    
    return 1;
  }
  
  private static int getNodeNetworks(CommandContext<ServerCommandSource> context) {
    List<NodeNetwork<?>> otherNetworks = new ArrayList<>();
    List<FluidNetwork> fluidNetworks = new ArrayList<>();
    List<EnergyNetwork> energyNetworks = new ArrayList<>();
    for (NodeNetwork<?> network : NodeNetworkManager.getAllNetworks()) {
      switch (network) {
        case EnergyNetwork energyNetwork -> energyNetworks.add(energyNetwork);
        case FluidNetwork fluidNetwork -> fluidNetworks.add(fluidNetwork);
        default -> otherNetworks.add(network);
      }
    }
    
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_node_networks.other").formatted(Formatting.GOLD), false);
    if (otherNetworks.isEmpty()) {
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_node_networks.none").formatted(Formatting.GRAY), false);
    }
    for (NodeNetwork<?> network : otherNetworks) {
      context.getSource().sendFeedback(() -> Text.literal(network.ID.toString()), false);
    }
    
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_node_networks.fluid").formatted(Formatting.GOLD), false);
    if (fluidNetworks.isEmpty()) {
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_node_networks.none").formatted(Formatting.GRAY), false);
    }
    for (FluidNetwork network : fluidNetworks) {
      context.getSource().sendFeedback(() -> Text.literal(network.ID.toString()), false);
    }
    
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_node_networks.energy").formatted(Formatting.GOLD), false);
    if (energyNetworks.isEmpty()) {
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_node_networks.none").formatted(Formatting.GRAY), false);
    }
    for (EnergyNetwork network : energyNetworks) {
      context.getSource().sendFeedback(() -> Text.literal(network.ID.toString()), false);
    }
    return 1;
  }
  
  private static int deleteLogs(CommandContext<ServerCommandSource> context){
    File[] logs = context.getSource().getServer().getPath("logs").toFile().listFiles();
    long files = 0;
    long data = 0;
    assert logs != null;
    for(File log : logs){
      if(log.getName().endsWith(".log.gz")){
        long fileSize = log.length();
        if(log.delete()) {
          files++;
          data += fileSize;
        }
      }
    }
    long finalFiles = files;
    long finalData = data;
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.clean_logs", finalFiles, finalData), true);
    return 1;
  }
  
  private static int getDataComponents(CommandContext<ServerCommandSource> context, int maxSize){
    PlayerEntity player = context.getSource().getPlayer();
    if(player == null || player.getMainHandStack() == ItemStack.EMPTY){
      context.getSource().sendError(Text.translatable("message.ntm.get_components.could_not_get_item"));
      return -1;
    }
    
    for(Component<?> component : player.getMainHandStack().getComponents()){
      String type = component.type().toString();
      String value = component.value().toString();
      MutableText feedback = Text.literal("");
      feedback.append(Text.literal(type + ": ").formatted(Formatting.YELLOW));
      if(value.length() > maxSize) {
        feedback.append(Text.translatable("message.ntm.get_components.value_max_length").formatted(Formatting.GRAY));
        context.getSource().sendFeedback(() -> feedback, false);
        continue;
      }
      feedback.append(Text.literal(value).formatted(Formatting.WHITE));
      context.getSource().sendFeedback(() -> feedback, false);
    }
    return 1;
  }
}
