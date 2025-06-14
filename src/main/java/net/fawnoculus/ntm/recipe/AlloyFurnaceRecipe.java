package net.fawnoculus.ntm.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.world.World;

public record AlloyFurnaceRecipe(Ingredient ingredient, ItemStack output) implements Recipe<AlloyFurnaceRecipeInput> {
  
  @Override
  public boolean matches(AlloyFurnaceRecipeInput input, World world) {
    return false;
  }
  
  @Override
  public ItemStack craft(AlloyFurnaceRecipeInput input, RegistryWrapper.WrapperLookup registries) {
    return null;
  }
  
  @Override
  public RecipeSerializer<? extends Recipe<AlloyFurnaceRecipeInput>> getSerializer() {
    return null;
  }
  
  @Override
  public RecipeType<? extends Recipe<AlloyFurnaceRecipeInput>> getType() {
    return null;
  }
  
  @Override
  public IngredientPlacement getIngredientPlacement() {
    return null;
  }
  
  @Override
  public RecipeBookCategory getRecipeBookCategory() {
    return null;
  }
}
