package com.movierp.server.user;

import com.movierp.server.persistence.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService implements UserDAO {

    private DatabaseConnector databaseConnector;

    public void setDatabaseConnector(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    @Override
    public User getUser(int id) {
        String query = "SELECT * FROM CINES WHERE IDCINE = ?";
        Connection connection = null;

        try {
            connection = databaseConnector.getNewConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, 1);
            User user = null;
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User(
                  rs.getString("NOMBRE")
                );
            }

            rs.close();
            ps.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void insertUser(User newUser) {

    }

    @Override
    public void updateUser(User modifiedUser) {

    }

    @Override
    public void deleteUser(int userToDelete) {

    }
}
