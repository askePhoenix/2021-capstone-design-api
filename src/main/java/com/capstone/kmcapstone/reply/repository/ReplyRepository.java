package com.capstone.kmcapstone.reply.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.reply.model.ReplyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReplyRepository extends JpaRepository<ReplyInfo, Long> {

    // 게시판에 포함된 댓글 가져오기
    @Query("select reply from ReplyInfo reply where reply.target_board = ?1 and reply.isDeleted = false")
    List<ReplyInfo> searchByAllBoard(BoardPageInfo boardPageInfo);

    // id 로 댓글 가져오기
    @Query("select reply from ReplyInfo reply where reply.id = ?1 and reply.isDeleted = false")
    ReplyInfo searchByID(Long id);


}
