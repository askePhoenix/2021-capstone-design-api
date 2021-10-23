package com.capstone.kmcapstone.board.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.model.BoardViewLogInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardViewLogRepository extends JpaRepository<BoardViewLogInfo, Long> {
    // 방문자 수 JPA
    @Query("select count(bv.id) from BoardViewLogInfo bv where bv.target_board = ?1")
    Integer CountAllByTargetBoard(BoardPageInfo board);
}
