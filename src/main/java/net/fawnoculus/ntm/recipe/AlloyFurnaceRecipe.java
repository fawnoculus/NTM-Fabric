package net.fawnoculus.ntm.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.List;

public record AlloyFurnaceRecipe(Ingredient ingredient, ItemStack output) implements Recipe<AlloyFurnaceRecipeInput> {
  
  public DefaultedList<Ingredient> getIngredients() {
    DefaultedList<Ingredient> list = DefaultedList.of();
    list.add(this.ingredient);
    return list;
  }
  
  @Override
  public boolean matches(AlloyFurnaceRecipeInput input, World world) {
    if(world.isClient()) {
      return false;
    }
    return ingredient.test(input.getStackInSlot(0));
  }
  
  @Override
  public ItemStack craft(AlloyFurnaceRecipeInput input, RegistryWrapper.WrapperLookup registries) {
    return output.copy();
  }
  
  @Override
  public RecipeSerializer<? extends Recipe<AlloyFurnaceRecipeInput>> getSerializer() {
    return ModRecipes.ALLOY_FURNACE_RECIPE_SERIALIZER;
  }
  
  @Override
  public RecipeType<? extends Recipe<AlloyFurnaceRecipeInput>> getType() {
    return ModRecipes.ALLOY_FURNACE_RECIPE_TYPE;
  }
  
  @Override
  public IngredientPlacement getIngredientPlacement() {
    return IngredientPlacement.forShapeless(List.of(ingredient));
  }
  
  @Override
  public RecipeBookCategory getRecipeBookCategory() {
    return RecipeBookCategories.CRAFTING_MISC;
  }
  
  public static class Serializer implements RecipeSerializer<AlloyFurnaceRecipe> {
    public static final MapCodec<AlloyFurnaceRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
        Ingredient.CODEC.fieldOf("ingredient").forGetter(AlloyFurnaceRecipe::ingredient),
        ItemStack.CODEC.fieldOf("result").forGetter(AlloyFurnaceRecipe::output)
    ).apply(inst, AlloyFurnaceRecipe::new));
    
    public static final PacketCodec<RegistryByteBuf, AlloyFurnaceRecipe> STREAM_CODEC =
        PacketCodec.tuple(
            Ingredient.PACKET_CODEC, AlloyFurnaceRecipe::ingredient,
            ItemStack.PACKET_CODEC, AlloyFurnaceRecipe::output,
            AlloyFurnaceRecipe::new);
    
    @Override
    public MapCodec<AlloyFurnaceRecipe> codec() {
      return CODEC;
    }
    
    @Override
    public PacketCodec<RegistryByteBuf, AlloyFurnaceRecipe> packetCodec() {
      return STREAM_CODEC;
    }
  }
}
