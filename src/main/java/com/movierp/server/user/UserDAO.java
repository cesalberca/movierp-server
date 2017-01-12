package com.movierp.server.user;

import java.util.List;

public interface UserDAO {
    User getUser(int id);
    List<User> getAllUsers();
    void insertUser(User newUser);
    void updateUser(User modifiedUser);
    void deleteUser(int userToDelete);
}

