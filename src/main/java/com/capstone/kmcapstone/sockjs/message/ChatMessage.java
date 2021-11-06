package com.capstone.kmcapstone.sockjs.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {

    public enum MessageType{
        ENTER,TALK
    }
    private MessageType type;
    private String roomId;//방 아이디
    private String sender;//보낸이
    private String message;//메세지

}
