package net.fawnoculus.ntm.recipe;

import net.fawnoculus.ntm.NTM;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModRecipes {
  public static final RecipeSerializer<AlloyFurnaceRecipe> ALLOY_FURNACE_RECIPE_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, NTM.id("alloy_furnace"), new AlloyFurnaceRecipe.Serializer());
  public static final RecipeType<AlloyFurnaceRecipe> ALLOY_FURNACE_RECIPE_TYPE = Registry.register(Registries.RECIPE_TYPE, NTM.id("alloy_furnace"), new RecipeType<AlloyFurnaceRecipe>() {
    @Override
    public String toString() {
      return "alloy_furnace";
    }});
  
  
  public static void initialize(){}
}
