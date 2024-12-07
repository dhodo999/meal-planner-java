package DAO.Implement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import DAO.MealPlans.MealPlansDAO;
import Database.*;
import Domain.MealPlan;

public class MealPlansDAOImpl implements MealPlansDAO {

    private final Connection connection;

    public MealPlansDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     * Creates a new meal plan in the database.
     * 
     * @param mealPlan the meal plan to be created
     * @return the generated ID for the created meal plan
     * @throws Exception
     */
    @Override
    public int createMealPlan(MealPlan mealPlan) throws Exception {

        String sql = QueryHelper.INSERT_MEALPLAN;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, mealPlan.getUserID());
            preparedStatement.setString(2, mealPlan.getDay());
            preparedStatement.setString(3, mealPlan.getMealTime());
            preparedStatement.setInt(4, mealPlan.getMealID());
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
     * @param mealPlanID
     * @return mealPlanID {int}
     * @return UserID {int}
     * @return UserName {String}
     * @return Day {String}
     * @return MealTime {String}
     * @return MealID {int}
     * @return MealName {String}
     * @throws Exception
     */
    @Override
    public MealPlan readMealPlanById(int mealPlanID) throws Exception {

        String sql = QueryHelper.SELECT_MEALPLAN_BY_ID;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealPlanID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new MealPlan(resultSet.getInt("PlanID"),
                            resultSet.getInt("UserID"),
                            resultSet.getString("Name"),
                            resultSet.getString("Day"),
                            resultSet.getString("MealTime"),
                            resultSet.getInt("MealID"),
                            resultSet.getString("MealName"));
                }
            }
        }
        return null;
    }

    /**
     * Read all from database
     * 
     * @return List<MealPlan>
     * @throws Exception
     */
    @Override
    public List<MealPlan> readAllMealPlans() throws Exception {

        List<MealPlan> mealPlans = new ArrayList<>();
        String sql = QueryHelper.SELECT_ALL_MEALPLANS;
        try (Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                mealPlans.add(new MealPlan(resultSet.getInt("PlanID"),
                        resultSet.getInt("UserID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Day"),
                        resultSet.getString("MealTime"),
                        resultSet.getInt("MealID"),
                        resultSet.getString("MealName")));
            }
        }
        return mealPlans;
    }

    /**
     * Updates an existing meal plan in the database.
     * 
     * @param mealPlan the meal plan to be updated
     * @return void
     * @throws Exception
     */
    @Override
    public void updateMealPlan(MealPlan mealPlan) throws Exception {

        String sql = QueryHelper.UPDATE_MEALPLAN;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealPlan.getUserID());
            preparedStatement.setString(2, mealPlan.getDay());
            preparedStatement.setString(3, mealPlan.getMealTime());
            preparedStatement.setInt(4, mealPlan.getMealID());
            preparedStatement.setInt(5, mealPlan.getPlanID());
            preparedStatement.executeUpdate();
        }
    }

    /**
     * Deletes a meal plan from the database.
     * 
     * @param mealPlanID the ID of the meal plan to be deleted
     * @return void
     * @throws Exception
     */
    @Override
    public void deleteMealPlan(int mealPlanID) throws Exception {

        String sql = QueryHelper.DELETE_MEALPLAN;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, mealPlanID);
            preparedStatement.executeUpdate();
        }
    }
}
