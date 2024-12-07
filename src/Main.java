import java.sql.Connection;

import DAO.Implement.*;
import DAO.Ingredients.*;
import DAO.MealPlans.*;
import DAO.Meals.*;
import DAO.MealIngredients.*;
import DAO.Users.*;
import Domain.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        try (Connection connection = Database.DatabaseUtil.connect()) {
            ReadUser readUser = new ReadUser();
            IngredientDAO ingredientDAO = new IngredientDAOImpl(connection);
            MealDAO mealDAO = new MealDAOImpl(connection);
            MealPlansDAO mealPlansDAO = new MealPlansDAOImpl(connection);
            MealIngredientsDAO mealIngredientsDAO = new MealIngredientsDAOImpl(connection);

            // Read a user by ID
            User fetchedUser = readUser.getUserById(2);
            if (fetchedUser != null) {
                System.out.println("User fetched successfully: " + fetchedUser.getName());
            } else {
                System.out.println("User not found");
            }

            // Read a user by name
            User fetchedUserByName = readUser.getUserByName("Afridho");
            if (fetchedUserByName != null) {
                System.out.println("User fetched successfully: " + fetchedUserByName.getName());
            } else {
                System.out.println("User not found");
            }

            // Create a new meal
            // Meal newMeal = new Meal("Nasi Goreng", "Lunch", "Nasi, Bawang, Telur, Kecap");
            // int newMealId = mealDAO.createMeal(newMeal);
            // System.out.println("New meal created with ID: " + newMealId);

            // // Create a new ingredient
            // Ingredient newIngredient = new Ingredient("Nasi", "Porsi", 1);
            // Ingredient newIngredient2 = new Ingredient("Bawang", "Biji", 2);
            // Ingredient newIngredient3 = new Ingredient("Telur", "Butir", 2);
            // Ingredient newIngredient4 = new Ingredient("Kecap", "Sendok", 1);
            // int newIngredientId = ingredientDAO.createIngredient(newIngredient);
            // int newIngredientId2 = ingredientDAO.createIngredient(newIngredient2);
            // int newIngredientId3 = ingredientDAO.createIngredient(newIngredient3);
            // int newIngredientId4 = ingredientDAO.createIngredient(newIngredient4);
            // System.out.println("New ingredient created with ID: " + newIngredientId);
            // System.out.println("New ingredient created with ID: " + newIngredientId2);
            // System.out.println("New ingredient created with ID: " + newIngredientId3);
            // System.out.println("New ingredient created with ID: " + newIngredientId4);

            // Read a meal by ID
            Meal fetchedMeal = mealDAO.readMealById(7);
            if (fetchedMeal != null) {
                System.out.println("Meal fetched successfully: " + fetchedMeal.getMealName());
            } else {
                System.out.println("Meal not found");
            }

            // Read all meals
            System.out.println("Fetching all meals...");
            for (Meal meal : mealDAO.readAllMeals()) {
                System.out.println(meal);
            }

            // Read an ingredient by ID
            Ingredient fetchedIngredient = ingredientDAO.readIngredientById(8);
            if (fetchedIngredient != null) {
                System.out.println("Ingredient fetched successfully: " + fetchedIngredient.getName());
            } else {
                System.out.println("Ingredient not found");
            }

            // Read all ingredients
            System.out.println("Fetching all ingredients...");
            for (Ingredient ingredient : ingredientDAO.readAllIngredients()) {
                System.out.println(ingredient);
            }

            // Create a new meal plan
            // MealPlan newMealPlan = new MealPlan(2, "Afridho", "Monday", "Lunch", 7, "Nasi Goreng");
            // int newMealPlanId = mealPlansDAO.createMealPlan(newMealPlan);
            // System.out.println("New meal plan created with ID: " + newMealPlanId);

            // Read a meal plan by ID
            MealPlan fetchedMealPlan = mealPlansDAO.readMealPlanById(1);
            if (fetchedMealPlan != null) {
                System.out.println("Meal plan fetched successfully: " + fetchedMealPlan.getMealName());
            } else {
                System.out.println("Meal plan not found");
            }

            // Read all meal plans
            System.out.println("Fetching all meal plans...");
            for (MealPlan mealPlan : mealPlansDAO.readAllMealPlans()) {
                System.out.println(mealPlan);
            }

            // // Create a new meal ingredient
            // MealIngredient newMealIngredient = new MealIngredient(7, "Nasi Goreng", 8, "Bawang");
            // int newMealIngredientId = mealIngredientsDAO.createMealIngredient(newMealIngredient);
            // System.out.println("New meal ingredient created with ID: " + newMealIngredientId);

            // Read a meal ingredient by ID
            MealIngredient fetchedMealIngredient = mealIngredientsDAO.readMealIngredientById(1);
            if (fetchedMealIngredient != null) {
                System.out.println("Meal ingredient fetched successfully: " + fetchedMealIngredient.getMealName() + " - " + fetchedMealIngredient.getIngredientName());
            } else {
                System.out.println("Meal ingredient not found");
            }

            // Read all meal ingredients
            System.out.println("Fetching all meal ingredients...");
            for (MealIngredient mealIngredient : mealIngredientsDAO.readAllMealIngredients()) {
                System.out.println(mealIngredient);
            }
        }
    }
}
