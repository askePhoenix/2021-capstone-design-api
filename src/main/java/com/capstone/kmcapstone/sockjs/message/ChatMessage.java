package com.capstone.kmcapstone.sockjs.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {

    public enum MessageType{
        ENTER,CHAT,LEAVE
    }

    public enum RoomType{
        ALL,PRIVATE
    }

    private RoomType roomType;//면접자와 면접관을 나누기 위해서
    private MessageType type;
    private String roomId;//방 아이디
    private String writer;//보낸이
    private String message;//메세지

}
