package com.capstone.kmcapstone.chat_room.service.Impl;

import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.chat_room.dto.member.ChatMemberDto;
import com.capstone.kmcapstone.chat_room.dto.search.ChatRoomDto;
import com.capstone.kmcapstone.chat_room.repository.ChatMemberRepository;
import com.capstone.kmcapstone.chat_room.repository.ChatRoomRepository;
import com.capstone.kmcapstone.chat_room.service.ChatRoomService;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.capstone.kmcapstone.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository repository;
    private final ChatMemberRepository memberRepository;
    private final BoardDetailRepository boardRepository;
    private final UserRepository userRepository;

    // 채팅방 가져오기
    @Override
    public List<ChatRoomDto> getChatRoom(Long target) {
        try {
            return repository.searchByBoard(
                    boardRepository.searchById(target).orElseThrow(NullPointerException::new)
            ).stream().map(ChatRoomDto::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return Collections.emptyList();
        }
    }

    // 채팅방 멤버 리스트 가져오기
    @Override
    public List<ChatMemberDto> getChatMember(Long target, String title) {
        try {
            return memberRepository.searchByChatRoom(
                    repository.searchById(target).orElseThrow(NullPointerException::new), title
            ).stream().map(ChatMemberDto::new).collect(Collectors.toList());
        } catch (NullPointerException e) {
            return Collections.emptyList();
        }
    }

    // 내가 Owner(주인)인 채팅방 조회
    @Override
    public List<ChatRoomDto> getMineRoom(Long owner){
        return repository.searchByOwner(
                userRepository.getById( owner )
        ).stream().map(ChatRoomDto::new).collect(Collectors.toList());
    }

    // 채팅방 생성하기
    private void createChatRoom(Long target_board, UserInfo userInfo) {

    }

    // 채팅방 검색하기

    //

}
