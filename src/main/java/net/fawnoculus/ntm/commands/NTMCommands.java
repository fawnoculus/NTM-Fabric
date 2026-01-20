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
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ComponentArgument;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.IdentifierArgument;
import net.minecraft.commands.arguments.UuidArgument;
import net.minecraft.core.component.TypedDataComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class NTMCommands {
    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
          Commands.literal("ntm")
            .then(Commands.literal("version")
              .executes(context -> version(context, environment)
              )
            )
            .then(Commands.literal("config")
              .requires(source -> allowCommands(source, environment))
              .then(Commands.literal("common")
                .then(Commands.literal("reload")
                  .executes(context -> reloadConfig(context, NTMConfig.COMMON_CONFIG_FILE))
                )
                .then(Commands.literal("get")
                  .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMConfig.COMMON_CONFIG_FILE))
                    .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
                  )
                )
                .then(Commands.literal("set")
                  .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMConfig.COMMON_CONFIG_FILE))
                    .then(Commands.argument("value", StringArgumentType.greedyString())
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
              .then(Commands.literal("world-default")
                .then(Commands.literal("reload")
                  .executes(context -> reloadConfig(context, NTMConfig.WORLD_CONFIG.defaultConfig()))
                )
                .then(Commands.literal("get")
                  .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::defaultConfig))
                    .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
                  )
                )
                .then(Commands.literal("set")
                  .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::defaultConfig))
                    .then(Commands.argument("value", StringArgumentType.greedyString())
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
              .then(Commands.literal("world")
                .then(Commands.literal("reload")
                  .executes(context -> reloadConfig(context, Objects.requireNonNull(NTMConfig.WORLD_CONFIG.worldConfig())))
                )
                .then(Commands.literal("get")
                  .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::worldConfig))
                    .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
                  )
                )
                .then(Commands.literal("set")
                  .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::worldConfig))
                    .then(Commands.argument("value", StringArgumentType.greedyString())
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
            .then(Commands.literal("message")
              .requires(source -> allowCommands(source, environment))
              .then(Commands.argument("targets", EntityArgument.players())
                .then(Commands.literal("send")
                  .then(Commands.argument("text", ComponentArgument.textComponent(registryAccess))
                    .executes(context ->
                      sendMessage(context,
                        EntityArgument.getPlayers(context, "targets"),
                        NTM.id("command_server"),
                        context.getArgument("text", Component.class),
                        2000.0f))
                    .then(Commands.argument("milliSeconds", FloatArgumentType.floatArg(0f, 10000f))
                      .executes(context ->
                        sendMessage(context,
                          EntityArgument.getPlayers(context, "targets"),
                          NTM.id("command_server"),
                          context.getArgument("text", Component.class),
                          context.getArgument("milliSeconds", Float.class)
                        ))
                      .then(Commands.argument("identifier", IdentifierArgument.id())
                        .executes(context ->
                          sendMessage(
                            context,
                            EntityArgument.getPlayers(context, "targets"),
                            context.getArgument("identifier", Identifier.class),
                            context.getArgument("text", Component.class),
                            context.getArgument("milliSeconds", Float.class)
                          ))
                      )
                    )
                  )
                )
                .then(Commands.literal("remove")
                  .then(Commands.argument("identifier", IdentifierArgument.id())
                    .executes(context -> removeMessage(context, EntityArgument.getPlayers(context, "targets"), context.getArgument("identifier", Identifier.class)))
                  )
                )
                .then(Commands.literal("remove_all")
                  .executes(context -> removeAllMessages(context, EntityArgument.getPlayers(context, "targets")))
                )
              )
            )
        ));

        if (NTMConfig.DEV_MODE.getValue()) {
            CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
                Commands.literal("ntm")
                  .then(Commands.literal("dev")
                    .requires(source -> allowCommands(source, null)
                    )
                    .then(Commands.literal("list_components")
                      .executes(context -> getDataComponents(context, 100))
                      .then(Commands.argument("max_length", IntegerArgumentType.integer())
                        .executes(context -> getDataComponents(context, context.getArgument("max_length", Integer.class)))
                      )
                    )
                    .then(Commands.literal("clean_logs")
                      .executes(NTMCommands::deleteLogs)
                    )
                    .then(Commands.literal("funny")
                      .executes(NTMCommands::funny)
                    )
                    .then(Commands.literal("set_dev_constant")
                      .then(Commands.argument("bool", BoolArgumentType.bool())
                        .executes(context -> setDevConstant(context, context.getArgument("bool", Boolean.class)))
                      )
                    )
                    .then(Commands.literal("get_node_networks")
                      .executes(NTMCommands::getNodeNetworks)
                      .then(Commands.argument("type", IdentifierArgument.id())
                        .executes(context -> getNodeNetworks(context, NodeNetworkManager.getType(context.getArgument("type", Identifier.class))))
                      )
                    )
                    .then(Commands.literal("node_network_info")
                      .then(Commands.argument("type", IdentifierArgument.id())
                        .then(Commands.argument("uuid", UuidArgument.uuid())
                          .executes(context -> getNodeNetworkInfo(context, NodeNetworkManager.getType(context.getArgument("type", Identifier.class)), context.getArgument("uuid", UUID.class)))
                        )
                      )
                    )
                    .then(Commands.literal("give_all_effects")
                      .executes(context -> giveAllEffects(context, List.of(Objects.requireNonNull(context.getSource().getEntity()))))
                      .then(Commands.argument("target", EntityArgument.entities())
                        .executes(context -> giveAllEffects(context, EntityArgument.getEntities(context, "target")))
                      )
                    )
                    .then(Commands.literal("set_energy")
                      .then(Commands.argument("energy", LongArgumentType.longArg())
                        .executes(context -> setEnergy(context, context.getArgument("energy", Long.class)))
                      )
                    )
                  )
              )
            );
        }
    }

    public static boolean allowCommands(CommandSourceStack source, @Nullable Commands.CommandSelection environment) {
        if (environment != null && environment.includeIntegrated) return true;
        return source.permissions().hasPermission(Permissions.COMMANDS_MODERATOR);
    }

    private static int version(CommandContext<CommandSourceStack> context, Commands.CommandSelection environment) {
        if (environment.includeDedicated) {
            context.getSource().sendSuccess(() -> Component.translatableEscape("message.ntm.version.server", NTM.METADATA.getVersion()), false);
        }
        if (environment.includeIntegrated) {
            context.getSource().sendSuccess(() -> Component.translatableEscape("message.ntm.version", NTM.METADATA.getVersion()), false);
        }
        return 1;
    }

    public static int reloadConfig(CommandContext<CommandSourceStack> context, ConfigFile file) {
        context.getSource().sendSuccess(() -> Component.translatable("command.ntm.reload_configs", file.getSubPath()), true);
        file.readFile();
        return 1;
    }

    public static <T> int getOptionInfo(CommandContext<CommandSourceStack> context, ConfigOption<T> option) {
        Codec<T> codec = option.getCodec();
        T defaultValue = option.getDefaultValue();
        T currentValue = option.getValue();

        Component nameText = Component.translatable("command.ntm.get_option_info.name").withStyle(ChatFormatting.BLUE)
          .append(Component.literal(option.getName()).withStyle(ChatFormatting.WHITE));
        context.getSource().sendSuccess(() -> nameText, false);

        if (option.getComment() != null) {
            Component commentText = Component.translatable("command.ntm.get_option_info.comment").withStyle(ChatFormatting.YELLOW)
              .append(Component.literal(option.getComment()).withStyle(ChatFormatting.WHITE));
            context.getSource().sendSuccess(() -> commentText, false);
        }

        Component defaultValueText = Component.translatable("command.ntm.get_option_info.default").withStyle(ChatFormatting.YELLOW)
          .append(Component.literal(codec.encodeStart(JsonOps.INSTANCE, defaultValue).getOrThrow().toString()).withStyle(ChatFormatting.WHITE));
        context.getSource().sendSuccess(() -> defaultValueText, false);

        Component currentValueText = Component.translatable("command.ntm.get_option_info.current_value").withStyle(ChatFormatting.YELLOW)
          .append(Component.literal(codec.encodeStart(JsonOps.INSTANCE, currentValue).getOrThrow().toString()).withStyle(ChatFormatting.WHITE));
        context.getSource().sendSuccess(() -> currentValueText, false);
        return 1;
    }

    public static int trySetOption(CommandContext<CommandSourceStack> context, ConfigFile file, ConfigOption<?> option, String value) {
        JsonElement element;
        try {
            element = JsonParser.parseString(value);
        } catch (JsonSyntaxException exception) {
            context.getSource().sendFailure(Component.translatable("command.ntm.set_config_value.invalid_json", value));
            return -2;
        }

        if (option.setValueFrom(element, JsonOps.INSTANCE)) {
            context.getSource().sendSuccess(() -> Component.translatable("command.ntm.set_config_value", option.getName(), value), true);
            file.writeFile();
            return 1;
        }

        context.getSource().sendFailure(Component.translatable("command.ntm.set_config_value.failed", option.getName(), value));
        return -1;
    }

    private static int removeMessage(CommandContext<CommandSourceStack> context, Collection<ServerPlayer> targets, Identifier identifier) {
        for (ServerPlayer player : targets) {
            ServerPlayNetworking.send(player, new RemoveMessagePayload(identifier));
        }
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.message.cleared_specific", identifier.toString(), targets.size()), true);
        return 1;
    }

    private static int removeAllMessages(CommandContext<CommandSourceStack> context, Collection<ServerPlayer> targets) {
        for (ServerPlayer player : targets) {
            ServerPlayNetworking.send(player, new RemoveAllMessagesPayload());
        }
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.message.cleared_all", targets.size()), true);
        return 1;
    }

    private static int sendMessage(CommandContext<CommandSourceStack> context, Collection<ServerPlayer> targets, Identifier identifier, Component text, float millis) {
        for (ServerPlayer player : targets) {
            ServerPlayNetworking.send(player, new AdvancedMessagePayload(new AdvancedMessage(identifier, text, millis)));
        }
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.message.sent", targets.size()), true);
        return 1;
    }

    private static int funny(CommandContext<CommandSourceStack> context) {
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.the_funny"), false);
        // This doesn't actually do anything
        return 1;
    }

    private static int setDevConstant(CommandContext<CommandSourceStack> context, boolean value) {
        SharedConstants.IS_RUNNING_IN_IDE = value;
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.set_dev_constant", value), false);
        return 1;
    }

    private static int giveAllEffects(CommandContext<CommandSourceStack> context, Collection<? extends Entity> targets) {
        int affectedTargets = 0;
        int immuneTargets = 0;

        for (Entity entity : targets) {
            if (entity instanceof LivingEntity livingEntity) {
                affectedTargets++;
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.ASTOLFIZATION, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.ASTOLFIZATION, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.CONTAMINATED, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.EXPLOSION, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.LEAD_POISONING, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.PHOSPHORUS_BURNS, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.POTION_SICKNESS, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.RAD_AWAY, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.RAD_X, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.STABILITY, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.TAINT, 30 * 20, 0, false, false, true));
                livingEntity.addEffect(new MobEffectInstance(NTMStatusEffects.TAINTED_HEART, 30 * 20, 0, false, false, true));
            } else {
                immuneTargets++;
            }
        }

        final int finalAffectedTargets = affectedTargets;
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.all_effects.affected_targets", finalAffectedTargets), true);
        if (immuneTargets > 0) {
            final int finalImmuneTargets = immuneTargets;
            context.getSource().sendSuccess(() -> Component.translatable("message.ntm.all_effects.immune_targets", finalImmuneTargets), true);
        }

        return 1;
    }

    private static int setEnergy(CommandContext<CommandSourceStack> context, long energy) {
        if (!context.getSource().isPlayer()) {
            context.getSource().sendFailure(Component.literal("message.ntm.must_be_executed_by_player"));
            return -2;
        }
        ItemStack stack = Objects.requireNonNull(context.getSource().getPlayer()).getMainHandItem();

        if (stack.getItem() instanceof EnergyContainingItem energyContainingItem) {
            energyContainingItem.setEnergy(stack, energy);
            context.getSource().sendSuccess(() -> Component.translatable("message.ntm.set_energy.success", stack.getItem().getName(), energy), true);
            return 1;
        } else {
            context.getSource().sendSuccess(() -> Component.translatable("message.ntm.set_energy.fail", stack.getItem().getName()), true);
            return -1;
        }
    }

    private static int getNodeNetworkInfo(CommandContext<CommandSourceStack> context, NetworkType type, UUID networkID) {
        NodeNetwork network = type.getNetwork(networkID);
        if (network == null) {
            context.getSource().sendSuccess(() -> Component.translatable("message.ntm.network_debug.no_network").withStyle(ChatFormatting.RED), false);
            return -1;
        }

        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.network_debug.network_name", Component.literal(network.ID.toString()).withStyle(ChatFormatting.WHITE)).withStyle(ChatFormatting.GOLD), false);
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.network_debug.network_type", network.TYPE.getName().withStyle(ChatFormatting.WHITE)).withStyle(ChatFormatting.YELLOW), false);
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.network_debug.node_count", Component.literal(String.valueOf(network.LOADED_NODES.size())).withStyle(ChatFormatting.WHITE)).withStyle(ChatFormatting.YELLOW), false);

        return 1;
    }

    private static int getNodeNetworks(CommandContext<CommandSourceStack> context) {
        for (NetworkType type : NodeNetworkManager.getAllTypes()) {
            context.getSource().sendSuccess(() -> Component.translatableEscape("message.ntm.get_node_networks", type.getName(), type.getId()).append(Component.literal(" " + type.getAllNetworks().size())), false);
        }
        return 1;
    }

    private static int getNodeNetworks(CommandContext<CommandSourceStack> context, NetworkType type) {
        context.getSource().sendSuccess(() -> Component.translatableEscape("message.ntm.get_node_networks", type.getName(), type.getId()), false);
        for (NodeNetwork network : type.getAllNetworks()) {
            context.getSource().sendSuccess(() -> Component.literal(network.ID.toString()), false);
        }
        return 1;
    }

    private static int deleteLogs(CommandContext<CommandSourceStack> context) {
        File[] logs = context.getSource().getServer().getFile("logs").toFile().listFiles();
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
        context.getSource().sendSuccess(() -> Component.translatable("message.ntm.clean_logs", finalFiles, finalData), true);
        return 1;
    }

    private static int getDataComponents(CommandContext<CommandSourceStack> context, int maxSize) {
        Player player = context.getSource().getPlayer();
        if (player == null || player.getMainHandItem() == ItemStack.EMPTY) {
            context.getSource().sendFailure(Component.translatable("message.ntm.get_components.could_not_get_item"));
            return -1;
        }

        for (TypedDataComponent<?> component : player.getMainHandItem().getComponents()) {
            String type = component.type().toString();
            String value = component.value().toString();
            MutableComponent feedback = Component.literal("");
            feedback.append(Component.literal(type + ": ").withStyle(ChatFormatting.YELLOW));
            if (value.length() > maxSize) {
                feedback.append(Component.translatable("message.ntm.get_components.value_max_length").withStyle(ChatFormatting.GRAY));
                context.getSource().sendSuccess(() -> feedback, false);
                continue;
            }
            feedback.append(Component.literal(value).withStyle(ChatFormatting.WHITE));
            context.getSource().sendSuccess(() -> feedback, false);
        }
        return 1;
    }
}
