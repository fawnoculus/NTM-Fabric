package net.fawnoculus.ntm.client.commands;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.FabricClientCommandSource;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.NTMConfig;
import net.fawnoculus.ntm.api.config.ConfigFile;
import net.fawnoculus.ntm.api.config.ConfigOption;
import net.fawnoculus.ntm.api.messages.AdvancedMessage;
import net.fawnoculus.ntm.client.NTMClientConfig;
import net.fawnoculus.ntm.client.api.messages.MessageSystem;
import net.fawnoculus.ntm.client.render.hud.FlashBangRender;
import net.fawnoculus.ntm.client.render.hud.HudWigglerRender;
import net.fawnoculus.ntm.commands.NTMCommands;
import net.fawnoculus.ntm.commands.arguments.ConfigOptionArgumentType;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.ComponentArgument;
import net.minecraft.commands.arguments.IdentifierArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

public class NTMClientCommands {

    public static void initialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> dispatcher.register(
            Commands.literal("ntm")
              .then(Commands.literal("config")
                .requires(source -> NTMCommands.allowCommands(source, environment))
                .then(Commands.literal("client")
                  .then(Commands.literal("reload")
                    .executes(context -> NTMCommands.reloadConfig(context, NTMClientConfig.CLIENT_CONFIG_FILE))
                  )
                  .then(Commands.literal("get")
                    .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMClientConfig.CLIENT_CONFIG_FILE))
                      .executes(context -> NTMCommands.getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
                    )
                  )
                  .then(Commands.literal("set")
                    .then(Commands.argument("option", ConfigOptionArgumentType.file(NTMClientConfig.CLIENT_CONFIG_FILE))
                      .then(Commands.argument("value", StringArgumentType.greedyString())
                        .executes(context -> NTMCommands.trySetOption(context,
                            NTMClientConfig.CLIENT_CONFIG_FILE,
                            ConfigOptionArgumentType.getOption(context, "option"),
                            context.getArgument("value", String.class)
                          )
                        )
                      )
                    )
                  )
                )
              )
          )
        );

        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
          ClientCommandManager.literal("ntm_client")
            .then(ClientCommandManager.literal("config")
              .then(ClientCommandManager.literal("client")
                .then(ClientCommandManager.literal("reload")
                  .executes(context -> reloadConfig(context, NTMClientConfig.CLIENT_CONFIG_FILE))
                )
                .then(ClientCommandManager.literal("get")
                  .then(ClientCommandManager.argument("option", ConfigOptionArgumentType.file(NTMClientConfig.CLIENT_CONFIG_FILE))
                    .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
                  )
                )
                .then(ClientCommandManager.literal("set")
                  .then(ClientCommandManager.argument("option", ConfigOptionArgumentType.file(NTMClientConfig.CLIENT_CONFIG_FILE))
                    .then(ClientCommandManager.argument("value", StringArgumentType.greedyString())
                      .executes(context -> trySetOption(context,
                          NTMClientConfig.CLIENT_CONFIG_FILE,
                          ConfigOptionArgumentType.getOption(context, "option"),
                          context.getArgument("value", String.class)
                        )
                      )
                    )
                  )
                )
              )
              .then(ClientCommandManager.literal("common")
                .then(ClientCommandManager.literal("reload")
                  .executes(context -> reloadConfig(context, NTMConfig.COMMON_CONFIG_FILE))
                )
                .then(ClientCommandManager.literal("get")
                  .then(ClientCommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.COMMON_CONFIG_FILE))
                    .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
                  )
                )
                .then(ClientCommandManager.literal("set")
                  .then(ClientCommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.COMMON_CONFIG_FILE))
                    .then(ClientCommandManager.argument("value", StringArgumentType.greedyString())
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
              .then(ClientCommandManager.literal("world-default")
                .then(ClientCommandManager.literal("reload")
                  .executes(context -> reloadConfig(context, NTMConfig.WORLD_CONFIG.defaultConfig()))
                )
                .then(ClientCommandManager.literal("get")
                  .then(ClientCommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::defaultConfig))
                    .executes(context -> getOptionInfo(context, ConfigOptionArgumentType.getOption(context, "option")))
                  )
                )
                .then(ClientCommandManager.literal("set")
                  .then(ClientCommandManager.argument("option", ConfigOptionArgumentType.file(NTMConfig.WORLD_CONFIG::defaultConfig))
                    .then(ClientCommandManager.argument("value", StringArgumentType.greedyString())
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
            )
            .then(ClientCommandManager.literal("version")
              .executes(NTMClientCommands::version)
            )
            .then(ClientCommandManager.literal("messages")
              .then(ClientCommandManager.literal("add_message")
                .then(ClientCommandManager.argument("text", ComponentArgument.textComponent(registryAccess))
                  .executes(context -> addMessage(
                      context,
                      context.getArgument("text", Component.class),
                      2000.0f,
                      NTM.id("command_client")
                    )
                  )
                  .then(ClientCommandManager.argument("millis", FloatArgumentType.floatArg(0.0f, 1000000.0f))
                    .executes(context -> addMessage(
                        context,
                        context.getArgument("text", Component.class),
                        context.getArgument("millis", Float.class),
                        NTM.id("command_client")
                      )
                    )
                    .then(ClientCommandManager.argument("identifier", IdentifierArgument.id())
                      .executes(context -> addMessage(
                          context,
                          context.getArgument("text", Component.class),
                          context.getArgument("millis", Float.class),
                          context.getArgument("identifier", Identifier.class)
                        )
                      )
                    )
                  )
                )
              )
              .then(ClientCommandManager.literal("remove_message")
                .then(ClientCommandManager.argument("identifier", IdentifierArgument.id())
                  .executes(context -> removeMessage(context, context.getArgument("identifier", Identifier.class)))
                )
              )
              .then(ClientCommandManager.literal("remove_all_messages")
                .executes(NTMClientCommands::clearMessages)
              )
              .then(ClientCommandManager.literal("enabled")
                .executes(NTMClientCommands::getMessagesEnabled)
                .then(ClientCommandManager.argument("enabled", BoolArgumentType.bool())
                  .executes(context -> setMessagesEnabled(context, context.getArgument("enabled", Boolean.class)))
                )
              )
            )
        ));

        if (NTMConfig.DEV_MODE.getValue()) {
            ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> dispatcher.register(
              ClientCommandManager.literal("ntm_client")
                .then(ClientCommandManager.literal("dev")
                  .then(ClientCommandManager.literal("test")
                    .executes(NTMClientCommands::test)
                  )
                  .then(ClientCommandManager.literal("force_disconnect")
                    .executes(NTMClientCommands::forceDisconnect)
                  )
                  .then(ClientCommandManager.literal("force_quit")
                    .executes(NTMClientCommands::forceQuit)
                  )
                )
            ));
        }
    }

    private static int version(CommandContext<FabricClientCommandSource> context) {
        context.getSource().sendFeedback(Component.translatable("message.ntm.version.client", NTM.METADATA.getVersion()));
        return 1;
    }

    private static int test(CommandContext<FabricClientCommandSource> context) {
        final double wiggleAngle = (float) (context.getSource().getEntity().getRandom().nextDouble() * Math.PI * 2);
        final double wiggleIntensity = 20;

        HudWigglerRender.addVelocity(
          (float) (wiggleIntensity * Math.cos(wiggleAngle)),
          (float) (wiggleIntensity * Math.sin(wiggleAngle))
        );

        FlashBangRender.addFlash(1.5f, 0.01f);
        return 1;
    }

    private static int forceQuit(CommandContext<FabricClientCommandSource> context) {
        context.getSource().getClient().stop();
        return 1;
    }

    private static int forceDisconnect(CommandContext<FabricClientCommandSource> context) {
        context.getSource().getWorld().disconnect(Component.translatable("message.ntm.force_disconnect"));
        context.getSource().getClient().disconnectWithSavingScreen();
        context.getSource().getClient().setScreen(new TitleScreen());
        return 1;
    }

    private static int clearMessages(CommandContext<FabricClientCommandSource> context) {
        context.getSource().sendFeedback(Component.translatable("message.ntm.message_client.cleared", MessageSystem.getAllMessages().size()));
        MessageSystem.removeAllMessages();
        return 1;
    }

    private static int removeMessage(CommandContext<FabricClientCommandSource> context, Identifier identifier) {
        context.getSource().sendFeedback(Component.translatable("message.ntm.message_client.removed", identifier.toString()));
        MessageSystem.removeAllMessages();
        return 1;
    }

    private static int addMessage(CommandContext<FabricClientCommandSource> context, Component text, float millis, Identifier identifier) {
        MessageSystem.addMessage(new AdvancedMessage(identifier, text, millis));
        context.getSource().sendFeedback(Component.translatable("message.ntm.message_client.added"));
        return 1;
    }

    private static int getMessagesEnabled(CommandContext<FabricClientCommandSource> context) {
        boolean enabled = MessageSystem.getIsEnabled();
        if (enabled) {
            context.getSource().sendFeedback(Component.translatable("message.ntm.message_client.is_enabled"));
        } else {
            context.getSource().sendFeedback(Component.translatable("message.ntm.message_client.is_disabled"));
        }
        return 1;
    }

    private static int setMessagesEnabled(CommandContext<FabricClientCommandSource> context, Boolean enabled) {
        MessageSystem.setIsEnabled(enabled);
        if (enabled) {
            context.getSource().sendFeedback(Component.translatable("message.ntm.message_client.set_enabled"));
        } else {
            context.getSource().sendFeedback(Component.translatable("message.ntm.message_client.set_disabled"));
        }
        return 1;
    }


    private static int reloadConfig(CommandContext<FabricClientCommandSource> context, ConfigFile file) {
        context.getSource().sendFeedback(Component.translatable("command.ntm.reload_configs", file.getSubPath()));
        file.readFile();
        return 1;
    }

    protected static <T> int getOptionInfo(CommandContext<FabricClientCommandSource> context, ConfigOption<T> option) {
        Codec<T> codec = option.getCodec();
        T defaultValue = option.getDefaultValue();
        T currentValue = option.getValue();

        Component nameText = Component.translatable("command.ntm.get_option_info.name").withStyle(ChatFormatting.BLUE)
          .append(Component.literal(option.getName()).withStyle(ChatFormatting.WHITE));
        context.getSource().sendFeedback(nameText);

        if (option.getComment() != null) {
            Component commentText = Component.translatable("command.ntm.get_option_info.comment").withStyle(ChatFormatting.YELLOW)
              .append(Component.literal(option.getComment()).withStyle(ChatFormatting.WHITE));
            context.getSource().sendFeedback(commentText);
        }

        Component defaultValueText = Component.translatable("command.ntm.get_option_info.default").withStyle(ChatFormatting.YELLOW)
          .append(Component.literal(codec.encodeStart(JsonOps.INSTANCE, defaultValue).getOrThrow().toString()).withStyle(ChatFormatting.WHITE));
        context.getSource().sendFeedback(defaultValueText);

        Component currentValueText = Component.translatable("command.ntm.get_option_info.current_value").withStyle(ChatFormatting.YELLOW)
          .append(Component.literal(codec.encodeStart(JsonOps.INSTANCE, currentValue).getOrThrow().toString()).withStyle(ChatFormatting.WHITE));
        context.getSource().sendFeedback(currentValueText);
        return 1;
    }

    private static int trySetOption(CommandContext<FabricClientCommandSource> context, ConfigFile file, ConfigOption<?> option, String value) {
        JsonElement element;
        try {
            element = JsonParser.parseString(value);
        } catch (JsonSyntaxException exception) {
            context.getSource().sendError(Component.translatable("command.ntm.set_config_value.invalid_json", value));
            return -2;
        }

        if (option.setValueFrom(element, JsonOps.INSTANCE)) {
            context.getSource().sendFeedback(Component.translatable("command.ntm.set_config_value", option.getName(), value));
            file.writeFile();
            return 1;
        }

        context.getSource().sendError(Component.translatable("command.ntm.set_config_value.failed", option.getName(), value));
        return -1;
    }
}
