package net.fawnoculus.ntm.commands;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.brigadier.arguments.*;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.api.config.ConfigOption;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.api.node.network.NetworkType;
import net.fawnoculus.ntm.api.node.network.NodeNetwork;
import net.fawnoculus.ntm.api.node.network.NodeNetworkManager;
import net.fawnoculus.ntm.commands.arguments.ConfigOptionArgumentType;
import net.fawnoculus.ntm.entity.NTMStatusEffects;
import net.fawnoculus.ntm.items.custom.container.energy.EnergyContainingItem;
import net.fawnoculus.ntm.network.s2c.AdvancedMessagePayload;
import net.fawnoculus.ntm.network.s2c.RemoveAllMessagesPayload;
import net.fawnoculus.ntm.network.s2c.RemoveMessagePayload;
import net.minecraft.SharedConstants;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.command.argument.IdentifierArgumentType;
import net.minecraft.command.argument.TextArgumentType;
import net.minecraft.command.argument.UuidArgumentType;
import net.minecraft.component.Component;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
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
import java.util.Objects;
import java.util.UUID;

public class NTMCommands {
  public static void initialize() {
    CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
      CommandManager.literal("ntm")
        .then(CommandManager.literal("version")
          .executes(context -> version(context, environment)
          )
        )
        .then(CommandManager.literal("config")
          .requires(source -> allowCommands(source, environment))
          .then(CommandManager.literal("common")
            .then(CommandManager.literal("reload")
              .executes(context -> reloadConfig(context, NTMConfig.COMMON_CONFIG_FILE))
            )
            .then(CommandManager.literal("get")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.COMMON_CONFIG_FILE))
                .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
              )
            )
            .then(CommandManager.literal("set")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.COMMON_CONFIG_FILE))
                .then(CommandManager.argument("value", StringArgumentType.greedyString())
                  .executes(context -> trySetOption(context,
                    NTMConfig.COMMON_CONFIG_FILE,
                    ConfigOptionArgumentType.getOption(context, "option"),
                    context.getArgument("value", String.class)
                    )
                  )
                )
              )
            )
          )
          .then(CommandManager.literal("dev")
            .then(CommandManager.literal("reload")
              .executes(context -> reloadConfig(context, NTMConfig.DEV_CONFIG_FILE))
            )
            .then(CommandManager.literal("get")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.DEV_CONFIG_FILE))
                .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
              )
            )
            .then(CommandManager.literal("set")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.DEV_CONFIG_FILE))
                .then(CommandManager.argument("value", StringArgumentType.greedyString())
                  .executes(context -> trySetOption(context,
                    NTMConfig.DEV_CONFIG_FILE,
                    ConfigOptionArgumentType.getOption(context, "option"),
                    context.getArgument("value", String.class)
                    )
                  )
                )
              )
            )
          )
          .then(CommandManager.literal("world-default")
            .then(CommandManager.literal("reload")
              .executes(context -> reloadConfig(context, NTMConfig.WORLD_CONFIG.defaultConfig()))
            )
            .then(CommandManager.literal("get")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::defaultConfig))
                .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
              )
            )
            .then(CommandManager.literal("set")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::defaultConfig))
                .then(CommandManager.argument("value", StringArgumentType.greedyString())
                  .executes(context -> trySetOption(context,
                    NTMConfig.WORLD_CONFIG.defaultConfig(),
                    ConfigOptionArgumentType.getOption(context, "option"),
                    context.getArgument("value", String.class)
                    )
                  )
                )
              )
            )
          )
          .then(CommandManager.literal("world")
            .then(CommandManager.literal("reload")
              .executes(context -> reloadConfig(context, Objects.requireNonNull(NTMConfig.WORLD_CONFIG.worldConfig())))
            )
            .then(CommandManager.literal("get")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::worldConfig))
                .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
              )
            )
            .then(CommandManager.literal("set")
              .then(CommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::worldConfig))
                .then(CommandManager.argument("value", StringArgumentType.greedyString())
                  .executes(context -> trySetOption(context,
                      NTMConfig.WORLD_CONFIG.worldConfig(),
                      ConfigOptionArgumentType.getOption(context, "option"),
                      context.getArgument("value", String.class)
                    )
                  )
                )
              )
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

    if (NTMConfig.DEV_MODE.getValue()) {
      CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
          CommandManager.literal("ntm")
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
                .executes(NTMCommands::deleteLogs)
              )
              .then(CommandManager.literal("funny")
                .executes(NTMCommands::funny)
              )
              .then(CommandManager.literal("set_dev_constant")
                .then(CommandManager.argument("bool", BoolArgumentType.bool())
                  .executes(context -> setDevConstant(context, context.getArgument("bool", Boolean.class)))
                )
              )
              .then(CommandManager.literal("get_node_networks")
                .executes(NTMCommands::getNodeNetworks)
                .then(CommandManager.argument("type", IdentifierArgumentType.identifier())
                  .executes(context -> getNodeNetworks(context, NodeNetworkManager.getType(context.getArgument("type", Identifier.class))))
                )
              )
              .then(CommandManager.literal("node_network_info")
                .then(CommandManager.argument("type", IdentifierArgumentType.identifier())
                  .then(CommandManager.argument("uuid", UuidArgumentType.uuid())
                    .executes(context -> getNodeNetworkInfo(context, NodeNetworkManager.getType(context.getArgument("type", Identifier.class)), context.getArgument("uuid", UUID.class)))
                  )
                )
              )
              .then(CommandManager.literal("give_all_effects")
                .executes(context -> giveAllEffects(context, List.of(Objects.requireNonNull(context.getSource().getEntity()))))
                .then(CommandManager.argument("target", EntityArgumentType.entities())
                  .executes(context -> giveAllEffects(context, EntityArgumentType.getEntities(context, "target")))
                )
              )
              .then(CommandManager.literal("set_energy")
                .then(CommandManager.argument("energy", LongArgumentType.longArg())
                  .executes(context -> setEnergy(context, context.getArgument("energy", Long.class)))
                )
              )
            )
        )
      );
    }
  }

  protected static boolean allowCommands(ServerCommandSource source, @Nullable CommandManager.RegistrationEnvironment environment) {
    if (environment != null && environment.integrated) return true;
    return source.hasPermissionLevel(NTMConfig.REQUIRED_COMMAND_PERMISSION.getValue());
  }

  private static int version(CommandContext<ServerCommandSource> context, CommandManager.RegistrationEnvironment environment) {
    if (environment.dedicated) {
      context.getSource().sendFeedback(() -> Text.stringifiedTranslatable("message.ntm.version.server", NTM.METADATA.getVersion()), false);
    }
    if (environment.integrated) {
      context.getSource().sendFeedback(() -> Text.stringifiedTranslatable("message.ntm.version", NTM.METADATA.getVersion()), false);
    }
    return 1;
  }

  protected static int reloadConfig(CommandContext<ServerCommandSource> context, ConfigFile file) {
    context.getSource().sendFeedback(() -> Text.translatable("command.ntm.reload_configs", file.getSubPath()), true);
    file.readFile();
    return 1;
  }

  protected static <T> int getOptionInfo(CommandContext<ServerCommandSource> context, ConfigOption<T> option) {
    Codec<T> codec = option.getCodec();
    T defaultValue = option.getDefaultValue();
    T currentValue = option.getValue();

    Text nameText = Text.translatable("command.ntm.get_option_info.name").formatted(Formatting.BLUE)
      .append(Text.literal(option.getName()).formatted(Formatting.WHITE));
    context.getSource().sendFeedback(() -> nameText, false);

    if (option.getComment() != null) {
      Text commentText = Text.translatable("command.ntm.get_option_info.comment").formatted(Formatting.YELLOW)
        .append(Text.literal(option.getComment()).formatted(Formatting.WHITE));
      context.getSource().sendFeedback(() -> commentText, false);
    }

    Text defaultValueText = Text.translatable("command.ntm.get_option_info.default").formatted(Formatting.YELLOW)
      .append(Text.literal(codec.encodeStart(JsonOps.INSTANCE, defaultValue).getOrThrow().toString()).formatted(Formatting.WHITE));
    context.getSource().sendFeedback(() -> defaultValueText, false);

    Text currentValueText = Text.translatable("command.ntm.get_option_info.current_value").formatted(Formatting.YELLOW)
      .append(Text.literal(codec.encodeStart(JsonOps.INSTANCE, currentValue).getOrThrow().toString()).formatted(Formatting.WHITE));
    context.getSource().sendFeedback(() -> currentValueText, false);
    return 1;
  }

  protected static int trySetOption(CommandContext<ServerCommandSource> context, ConfigFile file, ConfigOption<?> option, String value) {
    JsonElement element;
    try {
      element = JsonParser.parseString(value);
    } catch (JsonSyntaxException exception) {
      context.getSource().sendError(Text.translatable("command.ntm.set_config_value.invalid_json", value));
      return -2;
    }

    if (option.setValueFrom(element, JsonOps.INSTANCE)) {
      context.getSource().sendFeedback(() -> Text.translatable("command.ntm.set_config_value", option.getName(), value), true);
      file.writeFile();
      return 1;
    }

    context.getSource().sendError(Text.translatable("command.ntm.set_config_value.failed", option.getName(), value));
    return -1;
  }

  private static int removeMessage(CommandContext<ServerCommandSource> context, Collection<ServerPlayerEntity> targets, Identifier identifier) {
    for (ServerPlayerEntity player : targets) {
      ServerPlayNetworking.send(player, new RemoveMessagePayload(identifier));
    }
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.message.cleared_specific", identifier.toString(), targets.size()), true);
    return 1;
  }

  private static int removeAllMessages(CommandContext<ServerCommandSource> context, Collection<ServerPlayerEntity> targets) {
    for (ServerPlayerEntity player : targets) {
      ServerPlayNetworking.send(player, new RemoveAllMessagesPayload());
    }
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.message.cleared_all", targets.size()), true);
    return 1;
  }

  private static int sendMessage(CommandContext<ServerCommandSource> context, Collection<ServerPlayerEntity> targets, Identifier identifier, Text text, float millis) {
    for (ServerPlayerEntity player : targets) {
      ServerPlayNetworking.send(player, new AdvancedMessagePayload(new AdvancedMessage(identifier, text, millis)));
    }
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.message.sent", targets.size()), true);
    return 1;
  }

  private static int funny(CommandContext<ServerCommandSource> context) {
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.the_funny"), false);
    // This doesn't actually do anything
    return 1;
  }

  private static int setDevConstant(CommandContext<ServerCommandSource> context, boolean value) {
    SharedConstants.isDevelopment = value;
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.set_dev_constant", value), false);
    return 1;
  }

  private static int giveAllEffects(CommandContext<ServerCommandSource> context, Collection<? extends Entity> targets) {
    int affectedTargets = 0;
    int immuneTargets = 0;

    for (Entity entity : targets) {
      if (entity instanceof LivingEntity livingEntity) {
        affectedTargets++;
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.ASTOLFIZATION, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.ASTOLFIZATION, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.CONTAMINATED, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.EXPLOSION, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.LEAD_POISONING, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.PHOSPHORUS_BURNS, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.POTION_SICKNESS, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.RAD_AWAY, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.RAD_X, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.STABILITY, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.TAINT, 30 * 20, 0, false, false, true));
        livingEntity.addStatusEffect(new StatusEffectInstance(NTMStatusEffects.TAINTED_HEART, 30 * 20, 0, false, false, true));
      } else {
        immuneTargets++;
      }
    }

    final int finalAffectedTargets = affectedTargets;
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.all_effects.affected_targets", finalAffectedTargets), true);
    if (immuneTargets > 0) {
      final int finalImmuneTargets = immuneTargets;
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.all_effects.immune_targets", finalImmuneTargets), true);
    }

    return 1;
  }

  private static int setEnergy(CommandContext<ServerCommandSource> context, long energy) {
    if (!context.getSource().isExecutedByPlayer()) {
      context.getSource().sendError(Text.literal("message.ntm.must_be_executed_by_player"));
      return -2;
    }
    ItemStack stack = Objects.requireNonNull(context.getSource().getPlayer()).getMainHandStack();

    if (stack.getItem() instanceof EnergyContainingItem energyContainingItem) {
      energyContainingItem.setEnergy(stack, energy);
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.set_energy.success", stack.getItem().getName(), energy), true);
      return 1;
    } else {
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.set_energy.fail", stack.getItem().getName()), true);
      return -1;
    }
  }

  private static int getNodeNetworkInfo(CommandContext<ServerCommandSource> context, NetworkType type, UUID networkID) {
    NodeNetwork network = type.getNetwork(networkID);
    if (network == null) {
      context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.no_network").formatted(Formatting.RED), false);
      return -1;
    }

    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.network_name", Text.literal(network.ID.toString()).formatted(Formatting.WHITE)).formatted(Formatting.GOLD), false);
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.network_type", network.TYPE.getName().formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);
    context.getSource().sendFeedback(() -> Text.translatable("message.ntm.network_debug.node_count", Text.literal(String.valueOf(network.LOADED_NODES.size())).formatted(Formatting.WHITE)).formatted(Formatting.YELLOW), false);

    return 1;
  }

  private static int getNodeNetworks(CommandContext<ServerCommandSource> context) {
    for (NetworkType type : NodeNetworkManager.getAllTypes()) {
      context.getSource().sendFeedback(() -> Text.stringifiedTranslatable("message.ntm.get_node_networks", type.getName(), type.getId()).append(Text.literal(" " + type.getAllNetworks().size())), false);
    }
    return 1;
  }

  private static int getNodeNetworks(CommandContext<ServerCommandSource> context, NetworkType type) {
    context.getSource().sendFeedback(() -> Text.stringifiedTranslatable("message.ntm.get_node_networks", type.getName(), type.getId()), false);
    for (NodeNetwork network : type.getAllNetworks()) {
      context.getSource().sendFeedback(() -> Text.literal(network.ID.toString()), false);
    }
    return 1;
  }

  private static int deleteLogs(CommandContext<ServerCommandSource> context) {
    File[] logs = context.getSource().getServer().getPath("logs").toFile().listFiles();
    long files = 0;
    long data = 0;
    assert logs != null;
    for (File log : logs) {
      if (log.getName().endsWith(".log.gz")) {
        long fileSize = log.length();
        if (log.delete()) {
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

  private static int getDataComponents(CommandContext<ServerCommandSource> context, int maxSize) {
    PlayerEntity player = context.getSource().getPlayer();
    if (player == null || player.getMainHandStack() == ItemStack.EMPTY) {
      context.getSource().sendError(Text.translatable("message.ntm.get_components.could_not_get_item"));
      return -1;
    }

    for (Component<?> component : player.getMainHandStack().getComponents()) {
      String type = component.type().toString();
      String value = component.value().toString();
      MutableText feedback = Text.literal("");
      feedback.append(Text.literal(type + ": ").formatted(Formatting.YELLOW));
      if (value.length() > maxSize) {
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
