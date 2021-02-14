package org.htl.chat.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import java.util.*;

@Entity
public class User {
    @EmbeddedId
    private UserId id;
    private String userName;
    private String password;

    @OneToMany(mappedBy = "id")
    private List<Message> messages;

    @OneToMany(mappedBy = "id")
    private List<Chat> chats;

    public User() {
    }

    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
}
