package org.htl.chat.models;

public class MembershipDTO {
    private Integer id;
    private UserDTO user;
    private ChatDTO chat;

    public MembershipDTO() {
    }

    public MembershipDTO(Integer id, UserDTO user, ChatDTO chat) {
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
}
