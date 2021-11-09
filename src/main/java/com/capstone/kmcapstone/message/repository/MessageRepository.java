package com.capstone.kmcapstone.message.repository;

import com.capstone.kmcapstone.message.model.MessageInfo;
import com.capstone.kmcapstone.user.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageInfo , Long> {

    //자기가 보낸 메세지 확인
    @Query("select m from MessageInfo m where m.sender = ?1 and m.senderDeleted = false ")
    List<MessageInfo> searchMessageBySender(UserInfo userInfo);

    //받은 메세지 확인
    @Query("select m from MessageInfo m where m.receiver =?1 and m.receiverDeleted = false ")
    List<MessageInfo> searchMessageByReceiver(UserInfo userInfo);

    //확인안한 메세지들
    @Query("select m from MessageInfo m where m.receiver =?1 and m.isRead = false and m.receiverDeleted = false ")
    List<MessageInfo> searchNotReadMessageByReceiver(UserInfo userInfo);



}
