package com.capstone.kmcapstone.sockjs.handler;

import com.capstone.kmcapstone.sockjs.message.ChatMessage;
import com.capstone.kmcapstone.sockjs.room.ChatRoom;
import com.capstone.kmcapstone.sockjs.service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {

    private static List<WebSocketSession> sessionList = new ArrayList<>();
    private final ChatService chatService;
    private final ObjectMapper objectMapper;


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        log.info("payload:"+payload);

        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
        room.handleActions(session, chatMessage, chatService);

    }


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        chatService.sendMessage(session, "접속 하였습니다.");
        sessionList.add(session);
        log.info(session+":클라이언트 접속");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session,status);
        log.info(session+"클라이언트 접속 해제");
        sessionList.remove(session);


    }
}
