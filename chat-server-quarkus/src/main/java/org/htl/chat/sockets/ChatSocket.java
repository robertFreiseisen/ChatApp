package org.htl.chat.sockets;

import org.htl.chat.entities.Message;
import org.htl.chat.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.websocket.server.PathParam;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/chat/{username}")
@ApplicationScoped
public class ChatSocket {
    Map<String, Session> sessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        sessions.put(username, session);
    }

    @OnMessage
    public void onMessage(String messageContent, @PathParam("username") String username) {
        broadcast(new Message(1, new User(1, username, "pass"), messageContent));
    }

    @OnError
    public void onError(Session session, @PathParam("username") String username){
        sessions.remove(username);
    }

    private void broadcast(Message message) {
        sessions.values().forEach(s -> {
            s.getAsyncRemote().sendObject(message, result ->  {
                if (result.getException() != null) {
                    System.out.println("Unable to send message: " + result.getException());
                }
            });
        });
    }
}
