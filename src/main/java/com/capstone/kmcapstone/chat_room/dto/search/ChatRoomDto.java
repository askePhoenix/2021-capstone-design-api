package com.capstone.kmcapstone.chat_room.dto.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatRoomDto {
    // 채팅방 정보

    private Long id;
    // 기준 게시글
    private Long target_board;
    // 방 제목
    private String title;
    // 방 부연 설명
    private String descript;

}
