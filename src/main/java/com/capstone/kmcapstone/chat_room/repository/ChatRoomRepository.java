package com.capstone.kmcapstone.chat_room.repository;

import com.capstone.kmcapstone.chat_room.model.ChatRoomInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRoomRepository extends JpaRepository<ChatRoomInfo, Long> {
}
