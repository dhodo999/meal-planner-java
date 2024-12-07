package DAO.Meals;

import java.util.List;

import Domain.Meal;

public interface MealDAO {

    int createMeal(Meal meal) throws Exception;
    Meal readMealById(int mealID) throws Exception;
    List<Meal> readAllMeals() throws Exception;
    void updateMeal(Meal meal) throws Exception;
    void deleteMeal(int mealID) throws Exception;
}
