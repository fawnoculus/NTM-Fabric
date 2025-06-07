package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

public class ModCommands {
  
  public static void initialize(){
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
        CommandManager.literal("ntm")
            .then(CommandManager.literal("config")
                .requires(source -> source.hasPermissionLevel(1))
                .then(CommandManager.literal("server"))
                .then(CommandManager.literal("client")
                    .requires(source -> environment.integrated))
                .then(CommandManager.literal("world")))
            .then(CommandManager.literal("version")
                .executes(ModCommands::version))
    ));
  }
  
  private static int version(CommandContext<ServerCommandSource> context){
    context.getSource().sendFeedback(() -> Text.literal("NTM Server Version: " + NTM.METADATA.getVersion()), false);
    return 1;
  }
}
