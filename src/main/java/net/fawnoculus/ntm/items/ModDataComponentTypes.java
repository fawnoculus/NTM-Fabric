package net.fawnoculus.ntm.items;

import com.mojang.serialization.Codec;
import net.fawnoculus.ntm.main.NTM;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {
  
  private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
    return Registry.register(Registries.DATA_COMPONENT_TYPE, NTM.id(name), builderUnaryOperator.apply(ComponentType.builder()).build());
  }
  
  public static final ComponentType<Integer> SELECTED_ABILITY_COMPONENT = register("integer", integerBuilder -> integerBuilder.codec(Codec.INT));
  
  public static void initialize() {}
}
