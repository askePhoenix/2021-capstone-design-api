package com.capstone.kmcapstone.board.repository;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardDetailRepository extends JpaRepository<BoardPageInfo, Long> {
    @Query("select board from BoardPageInfo board where board.id = ?1 and board.isDeleted = false ")
    Optional<BoardPageInfo> searchById(Long id);

    @Query("select board from BoardPageInfo board where board.isDeleted = ?1")
    Page<BoardPageInfo> findByDeleted(boolean bool, Pageable pageable);
}
