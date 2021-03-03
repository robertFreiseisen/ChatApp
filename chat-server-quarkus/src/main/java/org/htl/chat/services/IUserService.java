package org.htl.chat.services;

import org.htl.chat.models.UserDTO;
import java.util.*;

public interface IUserService {
    public boolean login(UserDTO userToLogin);
    public boolean addUser(UserDTO userToAdd);
    public boolean removeUser(UserDTO userToRemove);
    public UserDTO getUserById(Integer id);
    public List<UserDTO> getAllUsers();
}
