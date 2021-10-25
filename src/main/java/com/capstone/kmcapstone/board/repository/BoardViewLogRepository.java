package com.capstone.kmcapstone.board.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.model.BoardViewLogInfo;
import com.capstone.kmcapstone.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardViewLogRepository extends JpaRepository<BoardViewLogInfo, Long> {
    // 방문자 수 JPA
    @Query("select count(bv.id) from BoardViewLogInfo bv where bv.target_board = ?1")
    Integer CountAllByTargetBoard(BoardPageInfo board);

    @Query("select bv from BoardViewLogInfo bv where bv.target_board = ?1 and bv.visitant = ?2")
    Optional<BoardViewLogInfo> searchByTargetBoard(BoardPageInfo board, UserInfo userInfo);
}
