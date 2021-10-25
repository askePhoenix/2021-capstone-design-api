package com.capstone.kmcapstone.board.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.model.RecommendBoardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecommendBoardRepository extends JpaRepository<RecommendBoardInfo, Long> {
    // 게시판 추천 JPA

    // 게시판 추천 수 가져오기
    @Query("select count(rb.id) from RecommendBoardInfo rb where rb.target_board = ?1")
    Integer CountAllTargetBoard(BoardPageInfo board);

}
