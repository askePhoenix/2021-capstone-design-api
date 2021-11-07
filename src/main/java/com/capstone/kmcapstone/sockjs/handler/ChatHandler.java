package com.capstone.kmcapstone.sockjs.handler;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.sockjs.message.ChatMessage;
import com.capstone.kmcapstone.sockjs.room.ChatRoom;
import com.capstone.kmcapstone.sockjs.service.ChatService;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.capstone.kmcapstone.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
@RequiredArgsConstructor
public class ChatHandler extends TextWebSocketHandler {


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

        UserInfo userInfo = chatService.getUserByEmail(session.getPrincipal().getName());
        log.info("닉네임:"+userInfo.getNick_name()+",userName:"+userInfo.getUsername());

        log.info(session+":클라이언트 접속");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        chatService.leave(session);
        super.afterConnectionClosed(session,status);
        log.info(session+"클라이언트 접속 해제");

    }
}
