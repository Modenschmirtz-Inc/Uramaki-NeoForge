package net.modenschmirtz.uramaki.item.components;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties TUNA = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1F).build();
    public static final FoodProperties COOKED_TUNA = new FoodProperties.Builder().nutrition(6).saturationModifier(0.8F).build();

    public static final FoodProperties COD_FILLET = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build();
    public static final FoodProperties SALMON_FILLET = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build();
    public static final FoodProperties TUNA_FILLET = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1F).build();

    public static final FoodProperties COOKED_COD_FILLET = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3F).build();
    public static final FoodProperties COOKED_SALMON_FILLET = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4F).build();
    public static final FoodProperties COOKED_TUNA_FILLET = new FoodProperties.Builder().nutrition(3).saturationModifier(0.4F).build();
}
