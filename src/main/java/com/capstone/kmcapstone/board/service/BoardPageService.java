package com.capstone.kmcapstone.board.service;

import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.user.model.UserInfo;

public interface BoardPageService {
    Long createBoardDetail(BoardPageDto dto, UserInfo info);

    BoardPageDto loadBoardDetail(Long id);
}
