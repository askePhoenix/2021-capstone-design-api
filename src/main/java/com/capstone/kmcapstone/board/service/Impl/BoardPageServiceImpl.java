package com.capstone.kmcapstone.board.service.Impl;

import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.board.dto.BoardPageableDto;
import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.board.service.BoardPageService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardPageServiceImpl implements BoardPageService {
    private final BoardDetailRepository repository;

    // 모든 페이지, 페이징 처리 후 가져오기
    @Override
    public BoardPageableDto getPage(Integer page, Integer size) {
        return new BoardPageableDto(repository.findByDeleted(false, PageRequest.of(page, size)));
    }

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

    @Override
    public BoardPageDto loadBoardDetail(Long id) {
        return new BoardPageDto(repository.searchById(id).
                orElseGet(
                        () -> BoardPageInfo.builder().id(-1L).build()
                ));
    }
}
