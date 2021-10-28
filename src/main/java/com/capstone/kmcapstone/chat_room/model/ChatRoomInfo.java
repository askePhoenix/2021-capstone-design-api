package com.capstone.kmcapstone.chat_room.model;

import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_room")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ChatRoomInfo {
    // 생성한 채팅방 정보
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 방장
    @JoinColumn(name = "owner")
    @ManyToOne
    private UserInfo owner;

    // 방 제목
    @Column(name = "title")
    private String title;

    // 부연 설명
    @Column(name = "descript")
    private String descript;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @CreationTimestamp
    @Column(name = "create_time")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @Column(name= "update_time")
    private LocalDateTime updateDateTime;



}
