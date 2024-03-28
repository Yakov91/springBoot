package com.example.springBoot.dao;

import com.example.springBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//@Transactional(readOnly = true)
public class UserDaoImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user"
                , User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User userUpdate) {
        User user = getUser(id);
        user.setName(userUpdate.getName());
        user.setLastName(userUpdate.getLastName());
        user.setEmail(userUpdate.getEmail());
        entityManager.merge(user);

    }


    @Override
    public void deleteUser(int userid) {
        entityManager.remove(entityManager.find(User.class, userid));
    }

    @Override
    public User getUser(int userid) {
        return entityManager.find(User.class, userid);
    }
}

