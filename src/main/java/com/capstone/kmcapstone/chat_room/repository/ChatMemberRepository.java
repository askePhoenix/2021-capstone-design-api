package com.capstone.kmcapstone.chat_room.repository;

import com.capstone.kmcapstone.chat_room.model.ChatMemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMemberRepository extends JpaRepository<ChatMemberInfo, Long> {
}
