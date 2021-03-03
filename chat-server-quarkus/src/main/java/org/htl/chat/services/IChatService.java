package org.htl.chat.services;

import org.htl.chat.entities.Chat;
import org.htl.chat.models.ChatDTO;
import java.util.*;

public interface IChatService {
    public boolean addChat(ChatDTO chatToAdd);
    public boolean removeChat(ChatDTO chatToRemove);
    public List<ChatDTO> getAllChats();
}
