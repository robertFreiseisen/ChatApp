package org.htl.chat.repositories;

import org.htl.chat.entities.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class UserRepository implements IUserRepository{
    private final EntityManager entityManager;

    public UserRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUser() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public void addUser(User userToAdd) {
        entityManager.persist(userToAdd);
    }

    @Override
    public void removeUser(User userToRemove) {
        entityManager.remove(userToRemove);
    }
}
