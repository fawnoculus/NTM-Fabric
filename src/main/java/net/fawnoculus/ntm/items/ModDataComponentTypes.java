package net.fawnoculus.ntm.items;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
  public static void initialize() {
  }
  
  private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
    return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(NTM.MOD_ID, name), builderUnaryOperator.apply(ComponentType.builder()).build());
  }
  
  public static final ComponentType<Integer> SELECTED_ABILITY_COMPONENT = register("integer", integerBuilder -> integerBuilder.codec(Codec.INT));
}
