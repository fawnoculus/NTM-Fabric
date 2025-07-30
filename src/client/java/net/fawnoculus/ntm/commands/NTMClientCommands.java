package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.misc.messages.AdvancedMessage;
import net.fawnoculus.ntm.misc.messages.MessageSystem;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class NTMClientCommands {
  
  public static void initialize() {
    ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
        ClientCommandManager.literal("ntm_client")
            .then(ClientCommandManager.literal("config")
            )
            .then(ClientCommandManager.literal("version")
                .executes(NTMClientCommands::version)
            )
            .then(ClientCommandManager.literal("dev")
                .then(ClientCommandManager.literal("force_quit")
                    .executes(NTMClientCommands::forceQuit))
                .then(ClientCommandManager.literal("force_disconnect")
                    .executes(NTMClientCommands::forceDisconnect)
                )
            )
            .then(ClientCommandManager.literal("messages")
                .then(ClientCommandManager.literal("add_message")
                    .then(ClientCommandManager.argument("text", TextArgumentType.text(registryAccess))
                        .executes(context ->
                            addMessage(
                                context,
                                context.getArgument("text", Text.class),
                                2000.0f,
                                NTM.id("command_client")
                            )
                        )
                        .then(ClientCommandManager.argument("millis", FloatArgumentType.floatArg(0.0f, 1000000.0f))
                            .executes(context ->
                                addMessage(
                                context,
                                context.getArgument("text", Text.class),
                                context.getArgument("millis", Float.class),
                                NTM.id("command_client")
                                )
                            )
                            .then(ClientCommandManager.argument("identifier", IdentifierArgumentType.identifier())
                                .executes(context ->
                                    addMessage(
                                        context,
                                        context.getArgument("text", Text.class),
                                        context.getArgument("millis", Float.class),
                                        context.getArgument("identifier", Identifier.class)
                                    )
                                )
                            )
                        )
                    )
                )
                .then(ClientCommandManager.literal("remove_message")
                    .then(ClientCommandManager.argument("identifier", IdentifierArgumentType.identifier())
                        .executes(context -> removeMessage(context, context.getArgument("identifier", Identifier.class)))
                    )
                )
                .then(ClientCommandManager.literal("remove_all_messages")
                    .executes(NTMClientCommands::clearMessages)
                )
                .then(ClientCommandManager.literal("enabled")
                    .executes(NTMClientCommands::getMessagesEnabled)
                    .then(ClientCommandManager.argument("enabled" ,BoolArgumentType.bool())
                        .executes(context -> setMessagesEnabled(context, context.getArgument("enabled", Boolean.class)))
                    )
                )
            )
    ));
  }
  private static int version(CommandContext<FabricClientCommandSource> context){
    context.getSource().sendFeedback(Text.translatable("message.ntm.version.client", NTM.METADATA.getVersion()));
    return 1;
  }
  private static int forceQuit(CommandContext<FabricClientCommandSource> context){
    Runtime.getRuntime().exit(0);
    return 1;
  }
  private static int forceDisconnect(CommandContext<FabricClientCommandSource> context){
    context.getSource().getWorld().disconnect();
    return 1;
  }
  private static int clearMessages(CommandContext<FabricClientCommandSource> context){
    context.getSource().sendFeedback(Text.translatable("message.ntm.message_client.cleared", MessageSystem.getAllMessages().size()));
    MessageSystem.removeAllMessages();
    return 1;
  }
  private static int removeMessage(CommandContext<FabricClientCommandSource> context, Identifier identifier){
    context.getSource().sendFeedback(Text.translatable("message.ntm.message_client.removed", identifier.toString()));
    MessageSystem.removeAllMessages();
    return 1;
  }
  private static int addMessage(CommandContext<FabricClientCommandSource> context, Text text, float millis, Identifier identifier){
    MessageSystem.addMessage(new AdvancedMessage(identifier, text, millis));
    context.getSource().sendFeedback(Text.translatable("message.ntm.message_client.added"));
    return 1;
  }
  private static int getMessagesEnabled(CommandContext<FabricClientCommandSource> context){
    boolean enabled = MessageSystem.getIsEnabled();
    if(enabled){
      context.getSource().sendFeedback(Text.translatable("message.ntm.message_client.is_enabled"));
    }else {
      context.getSource().sendFeedback(Text.translatable("message.ntm.message_client.is_disabled"));
    }
    return 1;
  }
  private static int setMessagesEnabled(CommandContext<FabricClientCommandSource> context, Boolean enabled){
    MessageSystem.setIsEnabled(enabled);
    if(enabled){
      context.getSource().sendFeedback(Text.translatable("message.ntm.message_client.set_enabled"));
    }else {
      context.getSource().sendFeedback(Text.translatable("message.ntm.message_client.set_disabled"));
    }
    return 1;
  }
}
