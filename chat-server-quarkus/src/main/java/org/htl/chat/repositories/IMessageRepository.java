package org.htl.chat.repositories;

import org.htl.chat.entities.Message;

import java.util.*;

public interface IMessageRepository {
    public List<Message> getAllMessages();
    public Message getMessageById(Integer id);
    public void removeMessage(Message messageToRemove);
    public void addMessage(Message messageToAdd);
}
