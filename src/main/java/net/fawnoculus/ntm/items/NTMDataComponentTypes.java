package net.fawnoculus.ntm.items;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.tool.AbilityHandler;
import net.minecraft.block.BlockState;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.math.BlockPos;

import java.util.function.UnaryOperator;

public class NTMDataComponentTypes {

    public static final ComponentType<AbilityHandler.StackData> ABILITY_COMPONENT_TYPE =
      register("ability", stackDataBuilder -> stackDataBuilder.codec(AbilityHandler.StackData.CODEC));
    public static final ComponentType<Integer> COOLDOWN_COMPONENT_TYPE =
      register("cooldown", integerBuilder -> integerBuilder.codec(Codec.INT));
    public static final ComponentType<Long> ENERGY_COMPONENT_TYPE =
      register("energy", longBuilder -> longBuilder.codec(Codec.LONG));
    public static final ComponentType<BlockPos> BLOCK_POS_COMPONENT_TYPE =
      register("block_pos", blockPosBuilder -> blockPosBuilder.codec(BlockPos.CODEC));
    public static final ComponentType<BlockState> BLOCK_STATE_COMPONENT_TYPE =
      register("block", blockBuilder -> blockBuilder.codec(BlockState.CODEC));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, NTM.id(name), builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void initialize() {
    }
}
