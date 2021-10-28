package com.capstone.kmcapstone.reply.dto;

import com.capstone.kmcapstone.reply.model.ReplyInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVIewDto {
    // html 에서 받은 DTO (일반 댓글과 대댓글을 구분함.)
    private Long id;
    private Long writer_id;
    private Long target_board_id;
    private Long target_reply_id;

    private String message;

    // action : 일반 댓글 = true, 대댓글 = false
    private boolean action;

}
