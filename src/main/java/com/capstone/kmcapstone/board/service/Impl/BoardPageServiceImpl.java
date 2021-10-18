package com.capstone.kmcapstone.board.service.Impl;

import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.board.service.BoardPageService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardPageServiceImpl implements BoardPageService {
    private final BoardDetailRepository repository;


    @Override
    public Long createBoardDetail(BoardPageDto dto, UserInfo info) {
        BoardPageInfo boardPageInfo = repository.save(
                BoardPageInfo.builder()
                        .title(dto.getTitle())
                        .isDeleted(false)
                        .contents(dto.getContents())
                        .writer(info)
                        .build()
        );
        return boardPageInfo.getId();
    }
}
