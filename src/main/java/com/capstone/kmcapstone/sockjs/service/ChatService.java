package com.capstone.kmcapstone.sockjs.service;


import com.capstone.kmcapstone.sockjs.message.ChatMessage;
import com.capstone.kmcapstone.sockjs.room.ChatRoom;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.capstone.kmcapstone.user.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class ChatService {

    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRooms;
    private final UserRepository userRepository;


    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom() {
        List<ChatRoom> rooms = new ArrayList<>(chatRooms.values());
        Collections.reverse(rooms);
        return rooms;

    }

    public ChatRoom findRoomBySession(WebSocketSession session) {
        List<ChatRoom> list = chatRooms.values().stream().toList();
        ChatRoom findRoom = null;
        for(ChatRoom chatRoom : list){
            if(chatRoom.getSessions().contains(session)){
                findRoom = chatRoom;
            }
        }
        return findRoom;
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.get(roomId);
    }

    public UserInfo getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseGet(()->UserInfo.builder().build());
    }


    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomId(randomId)
                .name(name)
                .build();
        chatRooms.put(randomId, chatRoom);

        return chatRoom;
    }

    public void dropRoom(ChatRoom chatRoom) {
        if(chatRooms.containsKey(chatRoom.getRoomId())){
            chatRooms.remove(chatRoom.getRoomId());
        }

    }


    public void leave(WebSocketSession session) {
        chatRooms.forEach((key , val)->{
            val.leave(session);
        });
    }


    public <T> void sendMessage(WebSocketSession session, ChatMessage message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message.getMessage())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
