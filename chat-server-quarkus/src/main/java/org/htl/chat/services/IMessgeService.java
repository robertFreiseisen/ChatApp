package org.htl.chat.services;

import org.htl.chat.models.ChatDTO;
import org.htl.chat.models.MessageDTO;
import java.util.*;

public interface IMessgeService {
    public boolean addMessage(MessageDTO messageToAdd);
    public boolean removeMessage(MessageDTO messageToRemove);
    public List<MessageDTO> getAllMessagesFromChat(ChatDTO chat);
}
