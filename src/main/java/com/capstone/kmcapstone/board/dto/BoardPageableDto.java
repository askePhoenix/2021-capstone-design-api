package com.capstone.kmcapstone.board.dto;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class BoardPageableDto {
    private final List<BoardTableViewDto> content;
    private final List<RecommendDto> recommends;
    private final List<BoardViewsDto> views;

    private final Pageable pageable;
    private final Integer totalPages;
    private final Long totalElements;
    private final boolean first;
    private final boolean last;
    private final boolean empty;

    public BoardPageableDto(Page<BoardPageInfo> page, List<BoardViewsDto> viewsDtos, List<RecommendDto> recommends) {
        this.content = page.getContent().stream().map(BoardTableViewDto::new).collect(Collectors.toList());
        this.pageable = page.getPageable();
        this.totalPages = page.getTotalPages();
        this.totalElements = page.getTotalElements();
        this.first = page.isFirst();
        this.last = page.isLast();
        this.empty = page.isEmpty();
        this.views = viewsDtos;
        this.recommends = recommends;
    }
}
