package com.capstone.kmcapstone.chat_room.service;

import com.capstone.kmcapstone.chat_room.dto.member.ChatMemberDto;
import com.capstone.kmcapstone.chat_room.dto.search.ChatRoomDto;

import java.util.List;

public interface ChatRoomService {
    // 채팅방 가져오기
    List<ChatRoomDto> getChatRoom(Long target);

    // 채팅방 멤버 리스트 가져오기
    List<ChatMemberDto> getChatMember(Long target, String title);
}
