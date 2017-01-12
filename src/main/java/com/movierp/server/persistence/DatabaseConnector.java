package com.movierp.server.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private final static String databaseName = "movierp";
    private final static String user = "default";
    private final static String password = "j4WeZjjnEH5TSxqJ";
    private final static String url = "jdbc:mysql://146.185.151.244:3306";

    private Connection connection;

    public DatabaseConnector() throws ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
    }

    public Connection getNewConnection() throws SQLException {
        connection = DriverManager.getConnection(url + "/" + databaseName, user, password);
        return getConnection();
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    private Connection getConnection() {
        return connection;
    }
}
