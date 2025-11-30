package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import net.fabricmc.fabric.api.command.v2.ArgumentTypeRegistry;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.commands.arguments.ConfigOptionArgumentType;
import net.fawnoculus.ntm.commands.arguments.serializer.ConfigOptionArgumentSerializer;
import net.minecraft.command.argument.serialize.ArgumentSerializer;

public class NTMCommandArguments {
    public static void initialize() {
        register("config_option", ConfigOptionArgumentType.class, new ConfigOptionArgumentSerializer());
    }

    private static <A extends ArgumentType<?>, T extends ArgumentSerializer.ArgumentTypeProperties<A>> void register(
      String name, Class<? extends A> clazz, ArgumentSerializer<A, T> serializer
    ) {
        ArgumentTypeRegistry.registerArgumentType(NTM.id(name), clazz, serializer);
    }
}
