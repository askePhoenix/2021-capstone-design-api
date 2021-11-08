package com.capstone.kmcapstone.chat_room.dto.search;

import com.capstone.kmcapstone.chat_room.model.ChatRoomInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChatRoomDto {
    // 채팅방 정보

    private Long id;
    // 기준 게시글
    private Long target_board_id;
    // 방장 id
    private Long owner_id;
    // 방장 nick_name
    private String owner_nick;
    // 방 제목
    private String title;
    // 방 부연 설명
    private String descript;

    public ChatRoomDto(ChatRoomInfo info) {
        this.id = info.getId();
        this.target_board_id = info.getTarget_board().getId();
        this.owner_id = info.getOwner().getId();
        this.owner_nick = info.getOwner().getNick_name();
        this.title = info.getTitle();
        this.descript = info.getDescript();
    }

}
