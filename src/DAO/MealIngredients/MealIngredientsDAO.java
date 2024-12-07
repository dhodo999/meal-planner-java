package DAO.MealIngredients;

import java.util.List;

import Domain.MealIngredient;

public interface MealIngredientsDAO {
    
    int createMealIngredient(MealIngredient mealIngredient) throws Exception;
    MealIngredient readMealIngredientById(int mealIngredientID) throws Exception;
    List<MealIngredient> readAllMealIngredients() throws Exception;
    void updateMealIngredient(MealIngredient mealIngredient) throws Exception;
    void deleteMealIngredient(int mealIngredientID) throws Exception;
}
