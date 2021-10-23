package com.capstone.kmcapstone.board.model;

import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "board_view_log")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardViewLogInfo {
    // 방문자 수 DB 엔티티 입니다.
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "visitant")
    @ManyToOne
    private UserInfo visitant;

    @JoinColumn(name = "target_board")
    @ManyToOne
    private BoardPageInfo target_board;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createDateTime;
}
