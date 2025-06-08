package net.fawnoculus.ntm.commands;

import net.fabricmc.fabric.api.command.v2.ArgumentTypeRegistry;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.command.argument.BlockPosArgumentType;
import net.minecraft.command.argument.serialize.ConstantArgumentSerializer;

public class ModCommandArguments {
  public static void initialize(){
    ArgumentTypeRegistry.registerArgumentType(
        NTM.id("data_component"),
        BlockPosArgumentType.class,
        ConstantArgumentSerializer.of(BlockPosArgumentType::new)
    );
  }
}
