package net.fawnoculus.ntm.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record AlloyFurnaceInput(ItemStack input) implements RecipeInput {
  @Override
  public ItemStack getStackInSlot(int slot) {
    return input;
  }
  
  @Override
  public int size() {
    return 2;
  }
}
