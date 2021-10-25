package com.capstone.kmcapstone.board.service.Impl;

import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.board.dto.BoardPageableDto;
import com.capstone.kmcapstone.board.dto.BoardViewsDto;
import com.capstone.kmcapstone.board.dto.RecommendDto;
import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.board.repository.BoardViewLogRepository;
import com.capstone.kmcapstone.board.repository.RecommendBoardRepository;
import com.capstone.kmcapstone.board.service.BoardPageService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardPageServiceImpl implements BoardPageService {
    private final BoardDetailRepository repository;
    private final BoardViewLogRepository viewLogRepository;
    private final RecommendBoardRepository recommendBoardRepository;

    // 모든 페이지, 페이징 처리 후 가져오기
    @Override
    public BoardPageableDto getPage(Integer page, Integer size) {
        final Page<BoardPageInfo> pageInfos = repository.findByDeleted(false, PageRequest.of(page, size));
        final List<BoardPageInfo> boardList = new ArrayList<>(pageInfos.getContent());

        final List<BoardViewsDto> viewsDtos = boardList.stream().map( viewLogRepository::CountAllByTargetBoard ).collect(Collectors.toList())
                .stream().map(BoardViewsDto::new).collect(Collectors.toList());
        final List<RecommendDto> recommendDtos = boardList.stream().map( recommendBoardRepository::CountAllTargetBoard ).collect(Collectors.toList())
                .stream().map(RecommendDto::new).collect(Collectors.toList());

        return new BoardPageableDto(pageInfos, viewsDtos, recommendDtos );
    }

    @Override
    public Long createBoardDetail(BoardPageDto dto, UserInfo info) {
        if(info == null){
            return -1L;
        }
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
