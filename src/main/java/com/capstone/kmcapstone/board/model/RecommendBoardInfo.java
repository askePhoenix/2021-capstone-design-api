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
@Table(name = "recommend_board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RecommendBoardInfo {
    // 게시판 추천 수 DB 엔티티 입니다.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "give_user")
    @ManyToOne
    private UserInfo give_user;

    @JoinColumn(name = "target_board")
    @ManyToOne
    private BoardPageInfo target_board;

    @Column(name = "is_used")
    private boolean isUsed;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name= "update_time")
    private LocalDateTime updateDateTime;

    @Builder
    public RecommendBoardInfo(Long id, UserInfo give_user, BoardPageInfo target_board, boolean isUsed, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.give_user = give_user;
        this.target_board = target_board;
        this.isUsed = isUsed;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}
