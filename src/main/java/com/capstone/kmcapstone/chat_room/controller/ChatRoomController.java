package com.capstone.kmcapstone.chat_room.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.chat_room.dto.member.ChatMemberDto;
import com.capstone.kmcapstone.chat_room.dto.search.ChatRoomDto;
import com.capstone.kmcapstone.chat_room.repository.ChatRoomRepository;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards/")
public class ChatRoomController {
    private final ChatRoomRepository repository;

    // 채팅방 만들기
    @PostMapping("{board}/chats")
    public ChatRoomDto createChatRoom(
            @LoginUser UserInfo userInfo,
            @PathVariable Long board) {

        // 채팅방 제목에는 특수문자 [/] 제외해야 합니다.
        return null;
    }

    // 채팅방 정보 가져오기
    @GetMapping("{board}/chats")
    public ChatRoomDto loadChatRoom(
            @PathVariable Long board) {
        return null;
    }

    // 채팅방 멤버 정보 가져오기
    @GetMapping("{board}/chats/{room}/member")
    public ChatMemberDto loadChatMember(
            @PathVariable Long board,
            @PathVariable String room
    ){
        return null;
    }

    // 채팅방 접속하기(웹소켓에서만 접근할 것)
    @PostMapping("{board}/chats/{room}")
    public ChatRoomDto visitChatRoom(
            @LoginUser UserInfo userInfo,
            @PathVariable Long board,
            @PathVariable String room) {
        return null;
    }

    // 채팅방 검색
    @PostMapping("{board}/chats/{room}/search/{keyword}")
    public List<ChatRoomDto> searchRoom(
            @PathVariable Long board,
            @PathVariable String keyword,
            @PathVariable String room){
        return null;
    }


    // 해당 게시판 연동

}
