package com.capstone.kmcapstone.board.model;

import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board_page")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardPageInfo {
    // 게시판 상세 정보 DB 엔티티 입니다.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "writer")
    @ManyToOne
    private UserInfo writer;


    @Column(name = "title")
    private String title;

    @Column(name = "contents", length = 8000)
    private String contents;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name= "update_time")
    private LocalDateTime updateDateTime;

    @Builder
    public BoardPageInfo(Long id, UserInfo writer, String title, String contents, boolean isDeleted) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.contents = contents;
        this.isDeleted = isDeleted;
    }
}
