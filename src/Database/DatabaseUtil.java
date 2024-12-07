package Database;

import java.sql.*;

public class DatabaseUtil {
    
    private static final String URL = "jdbc:mysql://localhost:3306/meal_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private static Connection connection = null;

    /**
     * Handling connection to the database
     * return singleton connection
     * 
     * @return connection
     * @throws SQLException
     */
    public static Connection connect() throws SQLException {

        if(connection == null || connection.isClosed()) {
            try {
                Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                return connection;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }

    /**
     * Close connection, PreparedStatement, and ResultSet to the database
     * 
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {

        try {
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
            System.err.println("Failed to close ResultSet: " + e.getMessage());
        }

        try {
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Failed to close PreparedStatement: " + e.getMessage());
        }

        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.err.println("Failed to close Connection: " + e.getMessage());
        }
    }

    /**
     * Close connection and PreparedStatement to the database
     * 
     * @param connection
     * @param preparedStatement
     */
    public static void close(Connection connection, PreparedStatement statement) {

        close(connection, statement, null);
    }

    /**
     * Close PreparaedStatement to the database
     * 
     * @param preparedStatement
     */
    public static void close(PreparedStatement preparedStatement) {

        try {
            if (preparedStatement != null) preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Failed to close PreparedStatement: " + e.getMessage());
        }
    }
}
