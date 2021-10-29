package com.capstone.kmcapstone.chat_room.model;


import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatMemberInfo {
    // 채팅방 참여자 정보
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 기준 채팅방
    @ManyToOne
    @JoinColumn(name = "in_room")
    private ChatRoomInfo in_room;

    // 채팅방 제목
    @Column(name = "title")
    private String title;

    // 채팅방 유저(참여자)
    @ManyToOne
    @JoinColumn(name = "member")
    private UserInfo member;

    @Column(name = "session")
    private Session session;

    // 방에 있는지 여부
    @Column(name = "is_deleted")
    private boolean isDeleted;

    // 방에 처음 접속한 시간
    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createDateTime;

    // 최근 방에 접속한 시간
    @UpdateTimestamp
    @Column(name= "update_time")
    private LocalDateTime updateDateTime;

}
