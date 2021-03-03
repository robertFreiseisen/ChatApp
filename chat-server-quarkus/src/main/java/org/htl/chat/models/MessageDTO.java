package org.htl.chat.models;

import org.htl.chat.entities.Message;

import javax.websocket.Decoder;

public class MessageDTO {
    private Integer id;
    private byte[] content;
    private UserDTO user;
    private ChatDTO chat;


    public MessageDTO() {
    }

    public MessageDTO(Integer id, byte[] content, UserDTO user, ChatDTO chat) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.chat = chat;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ChatDTO getChat() {
        return chat;
    }

    public void setChat(ChatDTO chat) {
        this.chat = chat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
