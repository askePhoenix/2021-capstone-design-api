package com.capstone.kmcapstone.reply.model;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
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
@Table(name = "reply")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReplyInfo {
    // 게시판 댓글 정보 DB 엔티티 입니다.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 댓글 작성자
    @JoinColumn(name = "writer")
    @ManyToOne
    private UserInfo writer;

    // 해당 게시글
    @JoinColumn(name = "target_board")
    @ManyToOne
    private BoardPageInfo target_board;

    // 대댓글
    @JoinColumn(name = "target_reply")
    @ManyToOne
    private ReplyInfo target_reply;

    // 댓글 내용
    @Column(name = "message")
    private String message;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name= "update_time")
    private LocalDateTime updateDateTime;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Builder
    public ReplyInfo(Long id, UserInfo writer, BoardPageInfo target_board,
                     ReplyInfo target_reply, LocalDateTime createDateTime,
                     LocalDateTime updateDateTime, String message, boolean isDeleted) {
        this.id = id;
        this.writer = writer;
        this.target_board = target_board;
        this.target_reply = target_reply;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
        this.message = message;
        this.isDeleted = isDeleted;
    }
}
