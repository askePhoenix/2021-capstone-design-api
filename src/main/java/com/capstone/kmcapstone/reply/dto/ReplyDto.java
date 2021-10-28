package com.capstone.kmcapstone.reply.dto;

import com.capstone.kmcapstone.reply.model.ReplyInfo;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyDto {
    private Long id;
    private Long writer_id;
    private Long target_board_id;
    private Long target_reply_id;

    private String message;
    private LocalDateTime create_time;
    private LocalDateTime update_time;

    public ReplyDto(ReplyInfo info) {
        this.id = info.getId();
        this.writer_id = info.getWriter().getId();
        this.target_board_id = info.getTarget_board() == null ? -1L : info.getTarget_board().getId();
        this.target_reply_id = info.getTarget_reply() == null ? -1L : info.getTarget_reply().getId();

        this.message = info.getMessage();
        this.create_time = info.getCreateDateTime();
        this.update_time = info.getUpdateDateTime();
    }
}
