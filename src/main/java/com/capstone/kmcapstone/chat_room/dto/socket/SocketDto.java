package com.capstone.kmcapstone.chat_room.dto.socket;

import lombok.Getter;
import org.hibernate.Session;

@Getter
public class SocketDto {
    private final Session session;

    public SocketDto(Session session) {
        this.session = session;
    }
}
