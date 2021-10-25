package com.capstone.kmcapstone.board.service;

import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.board.dto.BoardPageableDto;
import com.capstone.kmcapstone.user.model.UserInfo;

public interface BoardPageService {
    // 모든 페이지, 페이징 처리 후 가져오기
    BoardPageableDto getPage(Integer page, Integer size);

    Long createBoardDetail(BoardPageDto dto, UserInfo info);

    BoardPageDto loadBoardDetail(Long id);
}
