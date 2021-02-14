package org.htl.chat.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id")
    private User user;
    private String content;

    public Message(Integer id, User user, String content) {
        this.id = id;
        this.user = user;
        this.content = content;
    }

    public Message() {

    }
}
