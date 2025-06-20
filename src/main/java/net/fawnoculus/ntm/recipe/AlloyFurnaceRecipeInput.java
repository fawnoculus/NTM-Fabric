package net.fawnoculus.ntm.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record AlloyFurnaceRecipeInput(ItemStack input) implements RecipeInput {
  @Override
  public ItemStack getStackInSlot(int slot) {
    return input;
    /*
    return switch (slot){
      case 0 -> input1;
      case 1 -> input2;
      default -> throw new IllegalArgumentException("Recipe does not contain slot " + slot);
      
    };
     */
  }
  
  @Override
  public int size() {
    return 1;
  }
}
