package com.capstone.kmcapstone.chat_room.service;

import com.capstone.kmcapstone.chat_room.dto.member.ChatMemberDto;
import com.capstone.kmcapstone.chat_room.dto.search.ChatRoomDto;
import com.capstone.kmcapstone.user.model.UserInfo;

import java.util.List;

public interface ChatRoomService {
    // 채팅방 가져오기
    List<ChatRoomDto> getChatRoom(Long target);

    // 채팅방 멤버 리스트 가져오기
    List<ChatMemberDto> getChatMember(Long target, String title);

    // 내가 Owner(주인)인 채팅방 조회
    List<ChatRoomDto> getMineRoom(Long owner);
}
