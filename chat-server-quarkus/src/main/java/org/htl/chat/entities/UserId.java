package org.htl.chat.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.*;

@Embeddable
public class UserId {
    @OneToMany(mappedBy = "id")
    private List<Chat> chats;
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
}
