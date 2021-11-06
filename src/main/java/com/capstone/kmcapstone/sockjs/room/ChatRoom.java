package com.capstone.kmcapstone.sockjs.room;

import com.capstone.kmcapstone.sockjs.message.ChatMessage;
import com.capstone.kmcapstone.sockjs.service.ChatService;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.socket.WebSocketSession;

import java.util.HashSet;
import java.util.Set;

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
            chatMessage.setMessage(chatMessage.getWriter() + " : 님이 입장했습니다 ");
        } else if (chatMessage.getType().equals(ChatMessage.MessageType.LEAVE)) {
            chatMessage.setMessage(chatMessage.getWriter() + " : 님이 방을나갔습니다");
            leave(session);
        } else {
            chatMessage.setMessage(chatMessage.getWriter() + ":" + chatMessage.getMessage());
        }

        sendMessage(chatMessage , chatService);

    }

    public void leave(WebSocketSession session){

        sessions.remove(session);
    }

    public <T> void sendMessage(ChatMessage message, ChatService chatService) {
        sessions.parallelStream().forEach(session -> chatService.sendMessage(session , message));
    }

}
