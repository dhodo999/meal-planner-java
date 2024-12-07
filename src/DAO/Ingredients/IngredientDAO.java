package DAO.Ingredients;

import java.util.List;

import Domain.Ingredient;

public interface IngredientDAO {
    
    int createIngredient(Ingredient ingredient) throws Exception;
    Ingredient readIngredientById(int ingredientID) throws Exception;
    List<Ingredient> readAllIngredients() throws Exception;
    void updateIngredient(Ingredient ingredient) throws Exception;
    void deleteIngredient(int ingredientID) throws Exception;
}
