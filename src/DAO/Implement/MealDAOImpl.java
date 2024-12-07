package DAO.Implement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.Meals.MealDAO;
import Database.*;
import Domain.Meal;

public class MealDAOImpl implements MealDAO {

    private final Connection connection;

    public MealDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Creates a new meal in the database.
     * 
     * @param meal the meal to be created
     * @return the generated ID for the created meal
     * @throws Exception
     */
    @Override
    public int createMeal(Meal meal) throws Exception {

        String sql = QueryHelper.INSERT_MEAL;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, meal.getMealName());
            preparedStatement.setString(2, meal.getCategory());
            preparedStatement.setString(3, meal.getIngredients());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating meal failed, no ID obtained.");
                }
            }
        }
    }

    /**
     * Read by ID from database
     * 
     * @param mealID
     * @return mealID {int}
     * @return MealName {String}
     * @return Category {String}
     * @return Ingredients {String}
     * @throws Exception
     */
    @Override
    public Meal readMealById(int mealID) throws Exception {

        String sql = QueryHelper.SELECT_MEAL_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Meal(resultSet.getInt("MealID"),
                            resultSet.getString("MealName"),
                            resultSet.getString("Category"),
                            resultSet.getString("Ingredients"));
                }
            }
        }
        return null;
    }

    /**
     * Reads all meals from the database.
     * 
     * @return List<meal>
     * @throws Exception
     */
    @Override
    public List<Meal> readAllMeals() throws Exception {

        String sql = QueryHelper.SELECT_ALL_MEALS;
        List<Meal> meals = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                meals.add(new Meal(resultSet.getInt("MealID"),
                        resultSet.getString("MealName"),
                        resultSet.getString("Category"),
                        resultSet.getString("Ingredients")));

            }
        }
        return meals;
    }

    /**
     * Updates an existing meal in the database.
     * 
     * @param meal the meal to be updated
     * @return void
     * @throws Exception
     */
    @Override
    public void updateMeal(Meal meal) throws Exception {

        String sql = QueryHelper.UPDATE_MEAL;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, meal.getMealName());
            preparedStatement.setString(2, meal.getCategory());
            preparedStatement.setString(3, meal.getIngredients());
            preparedStatement.setInt(4, meal.getMealID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Deletes a meal from the database.
     * 
     * @param mealID
     * @return void
     * @throws Exception
     */
    @Override
    public void deleteMeal(int mealID) throws Exception {

        String sql = QueryHelper.DELETE_MEAL;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealID);
            preparedStatement.executeUpdate();
        }
    }
}
