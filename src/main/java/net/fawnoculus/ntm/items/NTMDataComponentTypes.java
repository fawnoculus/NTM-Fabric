package net.fawnoculus.ntm.items;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.api.tool.AbilityHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.UnaryOperator;

public class NTMDataComponentTypes {

    public static final DataComponentType<AbilityHandler.StackData> ABILITY_COMPONENT_TYPE =
      register("ability", stackDataBuilder -> stackDataBuilder.persistent(AbilityHandler.StackData.CODEC));
    public static final DataComponentType<Integer> COOLDOWN_COMPONENT_TYPE =
      register("cooldown", integerBuilder -> integerBuilder.persistent(Codec.INT));
    public static final DataComponentType<Long> ENERGY_COMPONENT_TYPE =
      register("energy", longBuilder -> longBuilder.persistent(Codec.LONG));
    public static final DataComponentType<BlockPos> BLOCK_POS_COMPONENT_TYPE =
      register("block_pos", blockPosBuilder -> blockPosBuilder.persistent(BlockPos.CODEC));
    public static final DataComponentType<BlockState> BLOCK_STATE_COMPONENT_TYPE =
      register("block", blockBuilder -> blockBuilder.persistent(BlockState.CODEC));

    private static <T> DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderUnaryOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, NTM.id(name), builderUnaryOperator.apply(DataComponentType.builder()).build());
    }

    public static void initialize() {
    }
}
