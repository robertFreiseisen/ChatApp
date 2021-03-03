package org.htl.chat.repositories;

import org.htl.chat.entities.Message;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class MessageRepository implements IMessageRepository{
    private final EntityManager entityManager;

    public MessageRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Message> getAllMessages() {
        return entityManager.createQuery("select m from Message m", Message.class).getResultList();
    }

    @Override
    public Message getMessageById(Integer id) {
        var result = entityManager.createQuery("select m from Message m where m.id = :id", Message.class);
        result.setParameter("id", id);
        return result.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void removeMessage(Message messageToRemove) {
        entityManager.remove(messageToRemove);
    }

    @Override
    public void addMessage(Message messageToAdd) {
        entityManager.persist(messageToAdd);
    }
}
