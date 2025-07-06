package net.fawnoculus.ntm.items.components;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
  public static final FoodComponent ALWAYS_EDIBLE = new FoodComponent.Builder().nutrition(1).saturationModifier(0.0f).alwaysEdible().build();

  public static final FoodComponent LEAD_APPLE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.0f).alwaysEdible().build();
  public static final FoodComponent SCHRABIDIUM_APPLE = new FoodComponent.Builder().nutrition(20).saturationModifier(1.0f).alwaysEdible().build();
}
