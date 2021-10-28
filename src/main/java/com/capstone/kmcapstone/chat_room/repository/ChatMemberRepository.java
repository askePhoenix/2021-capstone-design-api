package com.capstone.kmcapstone.chat_room.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.chat_room.dto.member.ChatMemberDto;
import com.capstone.kmcapstone.chat_room.model.ChatMemberInfo;
import com.capstone.kmcapstone.chat_room.model.ChatRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChatMemberRepository extends JpaRepository<ChatMemberInfo, Long> {

    // 해당 게시판 채팅방의 멤버 가져오기
    @Query("select cm from ChatMemberInfo cm where cm.in_room = ?1 and cm.title = ?2 and cm.isDeleted = false")
    List<ChatMemberDto> searchByChatRoom(ChatRoomInfo target, String title);
}
