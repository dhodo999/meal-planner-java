package DAO.Implement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.MealIngredients.MealIngredientsDAO;
import Database.*;
import Domain.MealIngredient;

public class MealIngredientsDAOImpl implements MealIngredientsDAO {

    private final Connection connection;

    public MealIngredientsDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Creates a new meal ingredient in the database.
     * 
     * @param mealIngredient the meal ingredient to be created
     * @return the generated ID for the created meal ingredient
     * @throws Exception
     */
    @Override
    public int createMealIngredient(MealIngredient mealIngredient) throws Exception {

        String sql = QueryHelper.INSERT_MEALINGREDIENT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, mealIngredient.getMealID());
            preparedStatement.setInt(2, mealIngredient.getIngredientID());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating meal ingredient failed, no ID obtained.");
                }
            }
        }
    }

    /**
     * Read by ID from database
     * 
     * @param mealIngredientID
     * @return mealIngredientID {int}
     * @return MealID {int}
     * @return IngredientID {int}
     * @return Quantity {int}
     * @throws Exception
     */
    @Override
    public MealIngredient readMealIngredientById(int mealIngredientID) throws Exception {

        String sql = QueryHelper.SELECT_MEALINGREDIENT_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealIngredientID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new MealIngredient(
                            resultSet.getInt("MealIngredientID"),
                            resultSet.getInt("MealID"),
                            resultSet.getString("MealName"),
                            resultSet.getInt("IngredientID"),
                            resultSet.getString("IngredientName"));
                }
            }
        }
        return null;
    }

    /**
     * Read all from database
     * 
     * @return List<MealIngredient>
     * @throws Exception
     */
    @Override
    public List<MealIngredient> readAllMealIngredients() throws Exception {
        
        List<MealIngredient> mealIngredients = new ArrayList<>();
        String sql = QueryHelper.SELECT_ALL_MEALINGREDIENTS;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                mealIngredients.add(new MealIngredient(
                        resultSet.getInt("MealIngredientID"),
                        resultSet.getInt("MealID"),
                        resultSet.getString("MealName"),
                        resultSet.getInt("IngredientID"),
                        resultSet.getString("IngredientName")));
            }
        }
        return mealIngredients;
    }

    /**
     * Update a meal ingredient in the database.
     * 
     * @param mealIngredient the meal ingredient to be updated
     * @return void
     * @throws Exception
     */
    @Override
    public void updateMealIngredient(MealIngredient mealIngredient) throws Exception {

        String sql = QueryHelper.UPDATE_MEALINGREDIENT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealIngredient.getMealID());
            preparedStatement.setInt(2, mealIngredient.getIngredientID());
            preparedStatement.setInt(4, mealIngredient.getMealIngredientID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Deletes a meal ingredient from the database.
     * 
     * @param mealIngredientID the ID of the meal ingredient to be deleted
     * @return void
     * @throws Exception
     */
    @Override
    public void deleteMealIngredient(int mealIngredientID) throws Exception {

        String sql = QueryHelper.DELETE_MEALINGREDIENT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealIngredientID);
            preparedStatement.executeUpdate();
        }
    }
}
