package com.capstone.kmcapstone.sockjs.room;

import com.capstone.kmcapstone.sockjs.message.ChatMessage;
import com.capstone.kmcapstone.sockjs.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Getter
public class ChatRoom {
    private String roomId;
    private String name;
    private Set<WebSocketSession> sessions = new HashSet<>();



    @Builder
    public ChatRoom(String roomId, String name) {
        this.roomId = roomId;
        this.name = name;
    }

    public void handleActions(WebSocketSession session, ChatMessage chatMessage , ChatService chatService) {
        if (chatMessage.getType().equals(ChatMessage.MessageType.ENTER)) {
            sessions.add(session);
            chatMessage.setMessage(chatMessage.getWriter() + " : 님이 입장했습니다 현재인원:"+sessions.size());
        } else if (chatMessage.getType().equals(ChatMessage.MessageType.LEAVE)) {
            leave(session);
            chatMessage.setMessage(chatMessage.getWriter() + " : 님이 방을나갔습니다 현재인원:"+sessions.size());
        } else {
            chatMessage.setMessage(chatMessage.getWriter() + ":" + chatMessage.getMessage());
        }

        sendMessage(chatMessage , chatService);

    }

    public void sendAll(WebSocketSession session, ChatMessage chatMessage , ChatService chatService) {
        chatMessage.setMessage(chatMessage.getWriter() + ":" + chatMessage.getMessage());
    }

    public void sendPrivate(WebSocketSession session, ChatMessage chatMessage , ChatService chatService) {

    }
    public WebSocketSession findSession(WebSocketSession session){
        WebSocketSession findSession =  null;
        if(sessions.contains(session)){
            findSession = session;
        };
        return findSession;
    }

    public void leave(WebSocketSession session){

        if (findSession(session) != null) {
            System.out.println(session +":이 방을 나갔습니다 .");
            sessions.remove(session);

        }


    }

    public <T> void sendMessage(ChatMessage message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session , message));
    }

}
