package com.capstone.kmcapstone.chat_room.service.Impl;

import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.chat_room.dto.member.ChatMemberDto;
import com.capstone.kmcapstone.chat_room.dto.search.ChatRoomDto;
import com.capstone.kmcapstone.chat_room.repository.ChatMemberRepository;
import com.capstone.kmcapstone.chat_room.repository.ChatRoomRepository;
import com.capstone.kmcapstone.chat_room.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatRoomServiceImpl implements ChatRoomService {
    private final ChatRoomRepository repository;
    private final ChatMemberRepository memberRepository;
    private final BoardDetailRepository boardRepository;

    // 채팅방 가져오기
    @Override
    public List<ChatRoomDto> getChatRoom(Long target){
        try {
            return repository.searchByBoard(
                    boardRepository.searchById(target).orElseThrow(NullPointerException::new)
            );
        } catch (NullPointerException e) {
            return Collections.emptyList();
        }
    }

    // 채팅방 멤버 리스트 가져오기
    @Override
    public List<ChatMemberDto> getChatMember(Long target, String title){
        try {
            return memberRepository.searchByChatRoom(
                    repository.searchById(target).orElseThrow(NullPointerException::new), title
            );
        } catch (NullPointerException e) {
            return Collections.emptyList();
        }
    }

}
