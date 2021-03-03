package org.htl.chat.repositories;

import org.htl.chat.models.ChatDTO;
import org.htl.chat.entities.Chat;

import java.util.*;

public interface IChatRepository {
    public List<Chat> getAllChats();
    public Chat getChatById(Integer id);
    public void addChat(Chat chatToAdd);
    public void removeChat(Chat chatToRemove);
}
