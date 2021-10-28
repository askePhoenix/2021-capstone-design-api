package com.capstone.kmcapstone.chat_room.service.Impl;

import com.capstone.kmcapstone.chat_room.dto.search.ChatRoomDto;
import com.capstone.kmcapstone.chat_room.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl {
    private final ChatRoomRepository repository;

    // 채팅방 가져오기
    public ChatRoomDto getChatRoom(Long target){
        return null;
    }

    // 채팅방 멤버 리스트 가져오기

}
