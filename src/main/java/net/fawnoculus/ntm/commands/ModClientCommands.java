package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.text.Text;

public class ModClientCommands {
  
  public static void initialize(){
    ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
        ClientCommandManager.literal("ntm_client")
            .then(ClientCommandManager.literal("config"))
            .then(ClientCommandManager.literal("version")
                .executes(ModClientCommands::version))
            .then(ClientCommandManager.literal("force_quit")
                .executes(ModClientCommands::forceQuit))
            .then(ClientCommandManager.literal("force_disconnect")
                .executes(ModClientCommands::forceDisconnect))
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
}
