package org.htl.chat.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Message implements Serializable {
    @Id
    private Integer id;

    @OneToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "id")
    private Chat chat;

    private byte[] content;

    private boolean isImage;

    public Message() {

    }

    public Message(Integer id, User user, Chat chat, byte[] content, boolean isImage) {
        this.id = id;
        this.user = user;
        this.chat = chat;
        this.content = content;
        this.isImage = isImage;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setImage(boolean image) {
        isImage = image;
    }
}
