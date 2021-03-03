package org.htl.chat.entities;

import javax.persistence.*;

@Entity
public class Membership {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Chat chat;

    public Membership() {
    }

    public Membership(Integer id, User user, Chat chat) {
        this.id = id;
        this.user = user;
        this.chat = chat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }
}
