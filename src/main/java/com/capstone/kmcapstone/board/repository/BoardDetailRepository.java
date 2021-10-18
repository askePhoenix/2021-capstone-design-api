package com.capstone.kmcapstone.board.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BoardDetailRepository extends JpaRepository<BoardPageInfo, Long> {
    @Query("select board.id from BoardPageInfo board where board.isDeleted = false ")
    BoardPageInfo searchById(Long id);
}
