package com.capstone.kmcapstone.message.model;

import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "message_info")
public class MessageInfo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //보낸이
    @JoinColumn(name = "sender")
    @ManyToOne
    private UserInfo sender;
    //받는이
    @JoinColumn(name = "receiver")
    @ManyToOne
    private UserInfo receiver;

    @Builder
    public MessageInfo(Long id, UserInfo sender, UserInfo receiver, String message, LocalDateTime sendDate,
                       LocalDateTime readDate, Boolean isRead, Boolean senderDeleted, Boolean receiverDeleted) {
        this.id = id;
        this.sender = sender;
        this.receiver = receiver;
        this.message = message;
        this.sendDate = sendDate;
        this.readDate = readDate;
        this.isRead = isRead;
        this.senderDeleted = senderDeleted;
        this.receiverDeleted = receiverDeleted;
    }

    //메세지
    @Column(name = "message")
    private String message;
    //보낸날짜
    @CreationTimestamp
    @Column(name = "send_date")
    private LocalDateTime sendDate;
    //읽은 날짜
    @Column(name = "read_date")
    private LocalDateTime readDate;
    //읽었는지 확인
    @Column(name = "is_read")
    private Boolean isRead;
    //보낸이가 삭제했는지 (보낸이한테 안보이게)
    @Column(name = "is_deleted_sender")
    private Boolean senderDeleted;
    @Column(name = "is_deleted_receiver")
    private Boolean receiverDeleted;


}
