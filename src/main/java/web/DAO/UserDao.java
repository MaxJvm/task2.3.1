package web.DAO;

import web.model.User;

import java.util.List;

public interface UserDao {

    void saveUser(User user);

    void updateUser(long id, String name, String surName);

    void removeUser(long id);

    User getUser(long id);

    List<User> getAllUsers();
}
