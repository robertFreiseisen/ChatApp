package org.htl.chat.entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(mappedBy = "id.user")
    private List<User> users;
    private Integer adminId;

    public Chat() {
    }
}
