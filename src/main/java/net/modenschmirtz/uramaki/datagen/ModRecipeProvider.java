package net.modenschmirtz.uramaki.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.modenschmirtz.uramaki.Uramaki;
import net.modenschmirtz.uramaki.item.ModItems;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        cookModRecipes(output, "smoking", RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, 100);
        cookModRecipes(output, "smelting", RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, 200);
        cookModRecipes(output, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING_RECIPE, CampfireCookingRecipe::new, 600);
    }

    private static <T extends AbstractCookingRecipe> void cookModRecipes(RecipeOutput output, String cooker, RecipeSerializer<T> serializer, AbstractCookingRecipe.Factory<T> recipeFactory, int cookingTime){
        simpleModCookingRecipe(output, cooker, serializer, recipeFactory, cookingTime, ModItems.TUNA, ModItems.COOKED_TUNA, 0.35F);
        simpleModCookingRecipe(output, cooker, serializer, recipeFactory, Math.round(cookingTime*0.5f), ModItems.COD_FILLET, ModItems.COOKED_COD_FILLET, 0.175F);
        simpleModCookingRecipe(output, cooker, serializer, recipeFactory, Math.round(cookingTime*0.5f), ModItems.SALMON_FILLET, ModItems.COOKED_SALMON_FILLET, 0.175F);
        simpleModCookingRecipe(output, cooker, serializer, recipeFactory, Math.round(cookingTime*0.5f), ModItems.TUNA_FILLET, ModItems.COOKED_TUNA_FILLET, 0.175F);
    }

    protected static <T extends AbstractCookingRecipe> void simpleModCookingRecipe(
            RecipeOutput recipeOutput,
            String cookingMethod,
            RecipeSerializer<T> cookingSerializer,
            AbstractCookingRecipe.Factory<T> recipeFactory,
            int cookingTime,
            ItemLike material,
            ItemLike result,
            float experience
    ) {
        SimpleCookingRecipeBuilder.generic(Ingredient.of(material), RecipeCategory.FOOD, result, experience, cookingTime, cookingSerializer, recipeFactory)
                .unlockedBy(getHasName(material), has(material))
                .save(recipeOutput, Uramaki.MOD_ID+":"+getItemName(result) + "_from_" + cookingMethod);
    }

    public static String hasItem(ItemLike item) {
        return "has_" + getItemPath(item);
    }

    public static String getItemPath(ItemLike item) {
        return BuiltInRegistries.ITEM.getKey(item.asItem()).getPath();
    }
}
