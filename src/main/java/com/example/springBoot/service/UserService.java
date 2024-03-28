package com.example.springBoot.service;



import com.example.springBoot.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(int id, User user);
    void deleteUser(int userid);
    User getUser(int userid);
}
