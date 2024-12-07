package DAO.Implement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.Ingredients.IngredientDAO;
import Database.*;
import Domain.Ingredient;

public class IngredientDAOImpl implements IngredientDAO {

    private final Connection connection;

    public IngredientDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Creates a new ingredient in the database.
     * 
     * @param ingredient the ingredient to be created
     * @return the generated ID for the created ingredient
     * @throws Exception
     */
    @Override
    public int createIngredient(Ingredient ingredient) throws Exception {

        String sql = QueryHelper.INSERT_INGREDIENT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setString(2, ingredient.getDescription());
            preparedStatement.setInt(3, ingredient.getQuantity());
            preparedStatement.executeUpdate();

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating ingredient failed, no ID obtained.");
                }
            }
        }
    }

    /**
     * Read by ID from database
     * 
     * @param ingredientID
     * @return IngredientID {int}
     * @return Name {String}
     * @return Description {String}
     * @throws Exception
     */
    @Override
    public Ingredient readIngredientById(int ingredientID) throws Exception {

        String sql = QueryHelper.SELECT_INGREDIENT_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, ingredientID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Ingredient(resultSet.getInt("ingredientID"),
                            resultSet.getString("IngredientName"),
                            resultSet.getString("Description"),
                            resultSet.getInt("Quantity"));
                }
            }
        }
        return null;
    }

    /**
     * Reads all ingredients from the database.
     * 
     * @return List<Ingredient>
     * @throws Exception
     */
    @Override
    public List<Ingredient> readAllIngredients() throws Exception {

        String sql = QueryHelper.SELECT_ALL_INGREDIENTS;
        List<Ingredient> ingredients = new ArrayList<>();
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                ingredients.add(new Ingredient(resultSet.getInt("ingredientID"),
                        resultSet.getString("IngredientName"),
                        resultSet.getString("Description"),
                        resultSet.getInt("Quantity")));
            }
        }
        return ingredients;
    }

    /**
     * Updates an existing ingredient in the database.
     * 
     * @param ingredient the ingredient to be updated
     * @return void
     * @throws Exception
     */
    @Override
    public void updateIngredient(Ingredient ingredient) throws Exception {

        String sql = QueryHelper.UPDATE_INGREDIENT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, ingredient.getName());
            preparedStatement.setString(2, ingredient.getDescription());
            preparedStatement.setInt(3, ingredient.getQuantity());
            preparedStatement.setInt(3, ingredient.getIngredientID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Deletes a ingredient from the database.
     * 
     * @param ingredientID
     * @return void
     * @throws Exception
     */
    @Override
    public void deleteIngredient(int ingredientID) throws Exception {

        String sql = QueryHelper.DELETE_INGREDIENT;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, ingredientID);
            preparedStatement.executeUpdate();
        }
    }
}
