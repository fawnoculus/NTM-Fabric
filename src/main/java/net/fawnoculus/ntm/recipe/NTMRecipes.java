package net.fawnoculus.ntm.recipe;

import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.recipe.custom.AlloyFurnaceRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class NTMRecipes {
    public static final RecipeSerializer<AlloyFurnaceRecipe> ALLOY_FURNACE_RECIPE_SERIALIZER = register("alloy_furnace", new AlloyFurnaceRecipe.Serializer());
    public static final RecipeType<AlloyFurnaceRecipe> ALLOY_FURNACE_RECIPE_TYPE = register("alloy_furnace");


    private static <T extends Recipe<?>> RecipeType<T> register(String name) {
        return Registry.register(Registries.RECIPE_TYPE, NTM.id(name), new RecipeType<T>() {
            public String toString() {
                return name;
            }
        });
    }

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String name, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, NTM.id(name), serializer);
    }

    public static void initialize() {
    }
}
