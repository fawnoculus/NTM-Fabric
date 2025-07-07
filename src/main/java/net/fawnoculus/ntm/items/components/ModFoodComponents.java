package net.fawnoculus.ntm.items.components;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
  // Saturation = nutrition * saturationModifier * 2, I don't know why it is like that
  public static final FoodComponent ALWAYS_EDIBLE = new FoodComponent.Builder().nutrition(0).saturationModifier(0.0f).alwaysEdible().build();

  public static final FoodComponent LEAD_APPLE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.0f).alwaysEdible().build();
  public static final FoodComponent SCHRABIDIUM_APPLE = new FoodComponent.Builder().nutrition(20).saturationModifier(0.5f).alwaysEdible().build();
  
  public static final FoodComponent WAFFLE_OF_MASS_DESTRUCTION = new FoodComponent.Builder().nutrition(20).saturationModifier(1.0f).build();
  
  public static final FoodComponent RADIOACTIVE_COTTON_CANDY = new FoodComponent.Builder().nutrition(5).saturationModifier(0.6f).build();
  public static final FoodComponent GLOWING_MUSHROOM_STEW = new FoodComponent.Builder().nutrition(6).saturationModifier(0.59f).build();
  public static final FoodComponent LEMON = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();
  public static final FoodComponent MRE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();
  public static final FoodComponent LOOPS = new FoodComponent.Builder().nutrition(4).saturationModifier(0.25f).build();
  public static final FoodComponent IT_BREAKFAST = new FoodComponent.Builder().nutrition(10).saturationModifier(0.5f).build();
  public static final FoodComponent SPONGEBOB_MACARONI = new FoodComponent.Builder().nutrition(5).saturationModifier(1f).build();
  public static final FoodComponent FOOD_ITEM = new FoodComponent.Builder().nutrition(2).saturationModifier(5f).build();
  public static final FoodComponent TWINKIE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.17f).build();
  public static final FoodComponent TV_STATIC_SANDWICH = new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build();
  public static final FoodComponent PUDDING = new FoodComponent.Builder().nutrition(6).saturationModifier(1f).build();
  public static final FoodComponent SCRAP_PANCAKE = new FoodComponent.Builder().nutrition(20).saturationModifier(0.5f).build();
  public static final FoodComponent CHICKEN_NUGGET = new FoodComponent.Builder().nutrition(Integer.MAX_VALUE).saturationModifier(0.5f).build();
  public static final FoodComponent MARSHMALLOW_ON_A_STICK = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f).build();
  public static final FoodComponent ROASTED_MARSHMALLOW_ON_A_STICK = new FoodComponent.Builder().nutrition(7).saturationModifier(1f).build();
  public static final FoodComponent CHEESE = new FoodComponent.Builder().nutrition(5).saturationModifier(0.7f).build();
  public static final FoodComponent CHEESE_QUESADILLA = new FoodComponent.Builder().nutrition(8).saturationModifier(1f).build();
  public static final FoodComponent GLYPHID_MEAT = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f).build();
  public static final FoodComponent GRILLED_GLYPHID_MEAT = new FoodComponent.Builder().nutrition(8).saturationModifier(0.75f).build();
  public static final FoodComponent ARIZONA_MUCHO_MANGO = new FoodComponent.Builder().nutrition(10).saturationModifier(0.6f).build();
  public static final FoodComponent RADIUM_CHOCOLATE = new FoodComponent.Builder().nutrition(0).saturationModifier(0).build();
}
