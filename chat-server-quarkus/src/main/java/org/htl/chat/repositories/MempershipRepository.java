package org.htl.chat.repositories;

import org.htl.chat.entities.Membership;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class MempershipRepository implements IMembershipRepository {
    private final EntityManager entityManager;

    public MempershipRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Membership> getAllMemberships() {
        return entityManager.createQuery("select m from Membership m", Membership.class).getResultList();
    }

    @Override
    public Membership getMembershipById(Integer userId, Integer chatId) {
        var result = entityManager.createQuery("select m from Membership m " +
                "where m.user.id = :userId and m.chat.id = :chatId", Membership.class);

        result.setParameter("userId", userId );
        result.setParameter("chatId", chatId);
        return result.getResultList().stream().findFirst().orElse(null);
    }

    @Override
    public void addMembership(Membership membershipToAdd) {
        entityManager.persist(membershipToAdd);
    }

    @Override
    public void removeMembership(Membership membershipToRemove) {
        entityManager.remove(membershipToRemove);
    }
}
