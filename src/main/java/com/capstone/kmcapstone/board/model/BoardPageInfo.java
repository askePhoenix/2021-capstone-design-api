package com.capstone.kmcapstone.board.model;

import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "board_page")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardPageInfo {
    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "writer")
    @ManyToOne
    private UserInfo writer;


    @Column(name = "title")
    private String title;

    @Column(name = "contents")
    private String contents;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    @Builder
    public BoardPageInfo(Long id, UserInfo writer, String title, String contents, boolean isDeleted) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
