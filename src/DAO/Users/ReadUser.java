package DAO.Users;

import Database.DatabaseUtil;
import Database.QueryHelper;
import Domain.User;

import java.sql.*;

public class ReadUser {

    /**
     * Fetch a user by ID from database
     * 
     * @param userID
     * @return UserID {int}
     * @return Name {String}
     * @return DateCreated {Timestamp}
     * @throws SQLException
     */
    public User getUserById(int userID) throws SQLException {

        String sql = QueryHelper.SELECT_USER_BY_ID;
        try (Connection connection = DatabaseUtil.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(resultSet.getInt("userID"), resultSet.getString("Name"),
                            resultSet.getTimestamp("DateCreated"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching user by ID: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * Fetch a user by Name from database
     * 
     * @param name
     * @return UserID {int}
     * @return Name {String}
     * @return DateCreated {Timestamp}
     * @throws SQLException
     */
    public User getUserByName(String name) throws SQLException {

        String sql = QueryHelper.SELECT_USER_BY_NAME;
        try (Connection connection = DatabaseUtil.connect();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new User(resultSet.getInt("userID"), resultSet.getString("Name"),
                            resultSet.getTimestamp("DateCreated"));
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching user by name: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}