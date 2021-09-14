package com.project.lebiton.dao.connction;

import java.sql.*;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/lebiDb";
    private static final String USER = "root";
    private static final String PASSWORD = "abc123.A";
    //String senha = "Leh2019";
    //String senha = "1234";


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement) throws SQLException {
        closeConnection(connection);

        if (statement != null) {
            statement.close();
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) throws SQLException {
        closeConnection(connection, statement);

        if (resultSet != null) {
            resultSet.close();
        }
    }

}
