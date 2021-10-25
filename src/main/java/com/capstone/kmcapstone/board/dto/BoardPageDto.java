package com.capstone.kmcapstone.board.dto;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardPageDto {
    // 게시판 정보를 가져오는 DTO 입니다.
    private Long id;
    private UserInfo writer;
    private String title;
    private String contents;
    private boolean is_deleted;

    private String writer_name;

    public BoardPageDto(BoardPageInfo searchById) {
        this.id = searchById.getId();
        this.title = searchById.getTitle();
        this.writer_name = searchById.getWriter() == null
                ? "empty" : searchById.getWriter().getNick_name();
        this.contents = searchById.getContents();
    }
}
