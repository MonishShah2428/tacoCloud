package com.taco.cloud.models;

public class TacoUDRUtils {

    public static ingredientUDT toIngredientUDT(Ingredient ingredient) {
        return new ingredientUDT(ingredient.getName(), ingredient.getType());
    }

}
