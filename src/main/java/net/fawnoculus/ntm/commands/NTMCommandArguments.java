package net.fawnoculus.ntm.commands;

import com.mojang.brigadier.arguments.ArgumentType;
import net.fabricmc.fabric.api.command.v2.ArgumentTypeRegistry;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.commands.arguments.ConfigOptionArgumentType;
import net.fawnoculus.ntm.commands.arguments.serializer.ConfigOptionArgumentSerializer;
import net.minecraft.commands.synchronization.ArgumentTypeInfo;

public class NTMCommandArguments {
    public static void initialize() {
        register("config_option", ConfigOptionArgumentType.class, new ConfigOptionArgumentSerializer());
    }

    private static <A extends ArgumentType<?>, T extends ArgumentTypeInfo.Template<A>> void register(
      String name, Class<? extends A> clazz, ArgumentTypeInfo<A, T> serializer
    ) {
        ArgumentTypeRegistry.registerArgumentType(NTM.id(name), clazz, serializer);
    }
}
