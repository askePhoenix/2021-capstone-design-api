package com.capstone.kmcapstone.board.dto;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardTableViewDto {
    // 게시판에 해당하는 정보를 테이블로 보내줄때 사용하는 DTO 입니다.
    private Long id;
    private String title;
    private String user_name;
    // 추천 수
    private Integer recommend_count;
    // 방문자 수
    private Integer viewer_count;
    // 작성 시간
    private LocalDateTime create_time;


    public BoardTableViewDto(BoardPageInfo info, Integer recommend_count, Integer viewer_count) {
        this.id = info.getId();
        this.title = info.getTitle();
        this.user_name = info.getWriter().getNick_name();
        this.recommend_count = recommend_count;
        this.viewer_count = viewer_count;
    }

    public BoardTableViewDto(BoardPageInfo info) {
        this.id = info.getId();
        this.title = info.getTitle();
        this.user_name = info.getWriter().getNick_name();
        this.create_time = info.getCreateDateTime();
    }
}
