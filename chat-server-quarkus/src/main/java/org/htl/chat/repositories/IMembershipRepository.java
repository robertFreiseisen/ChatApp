package org.htl.chat.repositories;

import org.htl.chat.entities.Membership;
import org.htl.chat.models.MembershipDTO;

import java.util.*;

public interface IMembershipRepository {
    public List<Membership> getAllMemberships();
    public Membership getMembershipById(Integer userId, Integer chatId);
    public void addMembership(Membership membershipToAdd);
    public void removeMembership(Membership membershipToRemove);
}