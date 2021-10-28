package com.capstone.kmcapstone.chat_room.dto.member;

import com.capstone.kmcapstone.chat_room.model.ChatMemberInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Session;

@Getter
@Setter
@NoArgsConstructor
public class ChatMemberDto {
    // 해당 채팅방 접속자 정보
    private Long id;
    private Long room_id;
    private String title;
    private Long member_id;
    private String member_name;

    private Session session;

    public ChatMemberDto(ChatMemberInfo info) {
        this.id = info.getId();
        this.room_id = info.getIn_room().getId();
        this.title = info.getTitle();
        this.member_id = info.getMember().getId();
        this.member_name = info.getMember().getNick_name();
        this.session = info.getSession();
    }
}
