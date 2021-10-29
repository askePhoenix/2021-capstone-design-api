package com.capstone.kmcapstone.chat_room.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.chat_room.model.ChatRoomInfo;
import com.capstone.kmcapstone.user.model.UserInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ChatRoomRepository extends JpaRepository<ChatRoomInfo, Long> {
    // 해당 게시판 채팅방 리스트 가져오기
    @Query("select cr from ChatRoomInfo cr where cr.target_board = ?1 and cr.isDeleted = false")
    List<ChatRoomInfo> searchByBoard(BoardPageInfo target);

    // 방 찾기 : id
    @Query("select cr from ChatRoomInfo cr where cr.id = ?1 and cr.isDeleted = false ")
    Optional<ChatRoomInfo> searchById(Long target);

    // 방 찾기 : owner
    @Query("select cr from ChatRoomInfo cr where cr.owner = ?1 and cr.isDeleted = false ")
    List<ChatRoomInfo> searchByOwner(UserInfo owner);

    // 1) 채팅방 제목 중복 확인
    // 채팅방 제목으로 찾기
    @Query("select cr from ChatRoomInfo cr where cr.title = ?1 and cr.isDeleted = false ")
    List<ChatRoomInfo> searchByTitle(String title, Pageable pageable);


}
