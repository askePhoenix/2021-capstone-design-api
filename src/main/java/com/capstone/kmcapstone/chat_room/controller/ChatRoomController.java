package com.capstone.kmcapstone.chat_room.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.chat_room.dto.member.ChatMemberDto;
import com.capstone.kmcapstone.chat_room.dto.search.ChatRoomDto;
import com.capstone.kmcapstone.chat_room.service.ChatRoomService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards/")
public class ChatRoomController {
    private final ChatRoomService service;

    // 채팅방 만들기
    @PostMapping("{board}/chats/{title}")
    public ChatRoomDto createChatRoom(
            @LoginUser UserInfo userInfo,
            @PathVariable Long board,
            @PathVariable String title
    ) {
        // 채팅방 제목에는 특수문자 [/] 제외해야 합니다. (html ajax 에서 처리 할 것)
        final String title_validated = title.replace("/", " ");

        // 1) 채팅방 제목 중복 확인
        // 2)

        return null;
    }

    // 채팅방 정보 가져오기
    @GetMapping("{board}/chats")
    public List<ChatRoomDto> loadChatRoom(
            @PathVariable Long board) {
        return service.getChatRoom(board);
    }

    // 채팅방 멤버 정보 가져오기
    @GetMapping("{board}/chats/{room}/member")
    public List<ChatMemberDto> loadChatMember(
            @PathVariable Long board,
            @PathVariable String room
    ){
        return service.getChatMember(board, room);
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

    // 방장으로 채팅방 찾기
    @GetMapping("chats/owners/{owner}")
    public List<ChatRoomDto> searchOwnerRoom(
            @PathVariable Long owner
    ) {
        return service.getMineRoom(owner);
    }

    // 본인의 채팅방 찾기
    @GetMapping("chats/mine")
    public List<ChatRoomDto> loadMineRoom(@LoginUser UserInfo userInfo) {
        return service.getMineRoom(userInfo.getId());
    }
}
