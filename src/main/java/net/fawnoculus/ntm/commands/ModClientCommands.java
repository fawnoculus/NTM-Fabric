package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fawnoculus.ntm.main.NTM;
import net.fawnoculus.ntm.util.messages.AdvancedMessage;
import net.fawnoculus.ntm.util.messages.MessageSystem;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class ModClientCommands {
  
  public static void initialize() {
    ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
        ClientCommandManager.literal("ntm_client")
            .then(ClientCommandManager.literal("config"))
            .then(ClientCommandManager.literal("version")
                .executes(ModClientCommands::version))
            .then(ClientCommandManager.literal("dev")
                .then(ClientCommandManager.literal("force_quit")
                    .executes(ModClientCommands::forceQuit))
                .then(ClientCommandManager.literal("force_disconnect")
                    .executes(ModClientCommands::forceDisconnect))
            
            .then(ClientCommandManager.literal("message")
                .then(ClientCommandManager.literal("add_message")
                    .executes(ModClientCommands::forceDisconnect)
                    .then(ClientCommandManager.argument("text", TextArgumentType.text(registryAccess))
                        .executes(context -> addMessage(context, context.getArgument("text", Text.class), 40f))
                        .then(ClientCommandManager.argument("ticks", FloatArgumentType.floatArg(0))
                            .executes(context -> addMessage(context, context.getArgument("text", Text.class), context.getArgument("ticks", Float.class))))))
                .then(ClientCommandManager.literal("clear_messages")
                    .executes(ModClientCommands::clearMessages))))
    ));
  }
  private static int version(CommandContext<FabricClientCommandSource> context){
    context.getSource().sendFeedback(Text.literal("NTM Client Version: " + NTM.METADATA.getVersion()));
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
    MessageSystem.removeAllMessages();
    return 1;
  }
  private static int addMessage(CommandContext<FabricClientCommandSource> context, Text text, float ticks){
    MessageSystem.addMessage(new AdvancedMessage(NTM.id("command_client"), text, ticks));
    return 1;
  }
}
