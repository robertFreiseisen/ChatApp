package org.htl.chat.repositories;

import org.htl.chat.entities.Chat;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class ChatRepository implements IChatRepository {
    private final EntityManager entityManager;

    public ChatRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Chat> getAllChats() {
        return entityManager.createQuery("select c from Chat c", Chat.class).getResultList();
    }

    @Override
    public Chat getChatById(Integer id) {
        var result = entityManager.createQuery("select c from Chat c where c.id = :id", Chat.class);
        result.setParameter("id", id);
        return result.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void addChat(Chat chatToAdd) {
        entityManager.persist(chatToAdd);
    }

    @Override
    public void removeChat(Chat chatToRemove) {
        entityManager.remove(chatToRemove);
    }
}
