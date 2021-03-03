package org.htl.chat.sockets;

import org.htl.chat.models.MembershipDTO;
import org.htl.chat.models.MessageDTO;
import org.htl.chat.services.IChatService;
import org.htl.chat.services.IMembershipService;
import org.htl.chat.services.IMessgeService;
import org.jose4j.base64url.Base64;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat/{userId}/{chatId}")
@ApplicationScoped
public class ChatSocket {
    private Map<MembershipDTO, Session> sessions = new ConcurrentHashMap<>();

    private final IMembershipService membershipService;
    private final IMessgeService messageService;
    private final IChatService chatService;

    public ChatSocket(IMembershipService membershipRepository, IMessgeService messageService, IChatService chatService) {
        this.membershipService = membershipRepository;
        this.messageService = messageService;
        this.chatService = chatService;
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") Integer userId, @PathParam("chatId") Integer chatId) {
        var membership = membershipService.getMembershipById(userId, chatId);

        if(membership != null)
            sessions.put(membership, session);
    }

    @OnMessage
    public void onMessage(Session session, String content, @PathParam("userId") Integer userId, @PathParam("chatId") Integer chatId) {
        var membership = membershipService.getMembershipById(userId, chatId);

        if(membership != null){
            var message = new MessageDTO(1, Base64.decode(content), membership.getUser(), membership.getChat());
            messageService.addMessage(message);
            broadcast(message);
        }
    }

    @OnError
    public void onError(Session session, @PathParam("userId") Integer userId, @PathParam("chatId") Integer chatId) {
        var membership = membershipService.getMembershipById(userId, chatId);

        if(membership != null)
            sessions.remove(membership);
    }

    @OnClose
    public void onClose(Session session, @PathParam("userId") Integer userId, @PathParam("chatId") Integer chatId){
        var membership = membershipService.getMembershipById(userId, chatId);

        if(membership != null)
            sessions.remove(membership);
    }


    private void broadcast(MessageDTO message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(Base64.encode(message.getContent()), result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }
}
