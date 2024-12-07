package Database;

public class QueryHelper {

    // User Queries
    public static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE UserID = ?";
    public static final String SELECT_USER_BY_NAME = "SELECT * FROM users WHERE Name = ?";

    // Ingredient Queries
    public static final String SELECT_ALL_INGREDIENTS = "SELECT * FROM ingredients";
    public static final String SELECT_INGREDIENT_BY_ID = "SELECT * FROM ingredients WHERE IngredientID = ?";
    public static final String INSERT_INGREDIENT = "INSERT INTO ingredients (IngredientName, Description) VALUES (?, ?)";
    public static final String UPDATE_INGREDIENT = "UPDATE ingredients SET IngredientName = ?, Description = ? WHERE IngredientID = ?";
    public static final String DELETE_INGREDIENT = "DELETE FROM ingredients WHERE IngredientID = ?";

    // Meal Queries
    public static final String SELECT_ALL_MEALS = "SELECT * FROM meals";
    public static final String SELECT_MEAL_BY_ID = "SELECT * FROM meals WHERE MealID = ?";
    public static final String INSERT_MEAL = "INSERT INTO meals (MealName, Category, Ingredients) VALUES (?, ?, ?)";
    public static final String UPDATE_MEAL = "UPDATE meals SET MealName = ?, Category = ?, Ingredients = ? WHERE MealID = ?";
    public static final String DELETE_MEAL = "DELETE FROM meals WHERE MealID = ?";

    // MealPlan Queries
    public static final String SELECT_ALL_MEALPLANS = "SELECT mp.PlanID, mp.UserID, u.Name AS Name, mp.Day, mp.MealTime, mp.MealID, m.MealName AS MealName " +
                                                      "FROM mealplans mp " +
                                                      "INNER JOIN users u ON mp.UserID = u.UserID " +
                                                      "INNER JOIN meals m ON mp.MealID = m.MealID";
    public static final String SELECT_MEALPLAN_BY_ID = "SELECT mp.PlanID, mp.UserID, u.Name AS Name, mp.Day, mp.MealTime, mp.MealID, m.MealName AS MealName " +
                                                       "FROM mealplans mp " +
                                                       "INNER JOIN users u ON mp.UserID = u.UserID " +
                                                       "INNER JOIN meals m ON mp.MealID = m.MealID " +
                                                       "WHERE mp.PlanID = ?";
    public static final String INSERT_MEALPLAN = "INSERT INTO mealplans (UserID, Day, MealTime, MealID) VALUES (?, ?, ?, ?)";
    public static final String UPDATE_MEALPLAN = "UPDATE mealplans SET UserID = ?, Day = ?, MealTime = ?, MealID = ? WHERE PlanID = ?";
    public static final String DELETE_MEALPLAN = "DELETE FROM mealplans WHERE PlanID = ?";

    // MealIngredient Queries
    public static final String SELECT_ALL_MEALINGREDIENTS = "SELECT mi.MealIngredientID, mi.MealID, m.MealName AS MealName, mi.IngredientID, i.IngredientName AS IngredientName " +
                                                            "FROM mealingredients mi " +
                                                            "INNER JOIN meals m ON mi.MealID = m.MealID " +
                                                            "INNER JOIN ingredients i ON mi.IngredientID = i.IngredientID";
    public static final String SELECT_MEALINGREDIENT_BY_ID = "SELECT mi.MealIngredientID, mi.MealID, m.MealName AS MealName, mi.IngredientID, i.IngredientName AS IngredientName " +
                                                             "FROM mealingredients mi " +
                                                             "INNER JOIN meals m ON mi.MealID = m.MealID " +
                                                             "INNER JOIN ingredients i ON mi.IngredientID = i.IngredientID " +
                                                             "WHERE mi.MealIngredientID = ?";
    public static final String INSERT_MEALINGREDIENT = "INSERT INTO mealingredients (MealID, IngredientID) VALUES (?, ?)";
    public static final String UPDATE_MEALINGREDIENT = "UPDATE mealingredients SET MealID = ?, IngredientID = ? WHERE MealIngredientID = ?";
    public static final String DELETE_MEALINGREDIENT = "DELETE FROM mealingredients WHERE MealIngredientID = ?";

    // Debug
    public static void PrintQuery(String query) {
        System.out.println("Executing query: " + query);
    }
}