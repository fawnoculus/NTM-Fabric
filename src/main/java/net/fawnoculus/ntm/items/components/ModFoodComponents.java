package net.fawnoculus.ntm.items.components;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
  public static final FoodComponent ALWAYS_EDIBLE = new FoodComponent.Builder().nutrition(0).saturationModifier(0.0f).alwaysEdible().build();
}
