package com.example.springBoot.dao;

import com.example.springBoot.model.User;
import org.springframework.stereotype.Repository;


import java.util.List;
@Repository
public interface UserDAO {
    List<User> getAllUsers();
    void addUser(User user);

    void updateUser(int id, User userUpdate);

    void deleteUser(int userid);

    User getUser(int userid);
}
