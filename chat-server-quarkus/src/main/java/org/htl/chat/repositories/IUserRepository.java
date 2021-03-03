package org.htl.chat.repositories;

import org.htl.chat.models.UserDTO;
import org.htl.chat.entities.User;
import java.util.*;

public interface IUserRepository {
    public List<User> getAllUser();
    public User getUserById(Integer id);
    public void addUser(User userToAdd);
    public void removeUser(User userToRemove);
}
