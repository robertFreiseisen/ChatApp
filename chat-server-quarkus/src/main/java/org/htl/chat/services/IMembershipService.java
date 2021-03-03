package org.htl.chat.services;

import org.htl.chat.models.MembershipDTO;

import java.util.List;

public interface IMembershipService {
    public boolean addMembership(MembershipDTO membershipToAdd);
    public boolean removeMembership(MembershipDTO membershipToRemove);
    public List<MembershipDTO> getAllMemberships();
    public MembershipDTO getMembershipById(Integer userId, Integer chatId);
}
