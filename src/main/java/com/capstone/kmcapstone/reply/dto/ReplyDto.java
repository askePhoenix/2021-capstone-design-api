package com.capstone.kmcapstone.reply.dto;

import com.capstone.kmcapstone.reply.model.ReplyInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ReplyDto {
    // reply 을 백엔드에서 가져온 DTO
    private Long id;
    private Long writer_id;
    private String writer_nickname;
    private Long target_board_id;
    private Long target_reply_id;

    private List<ReplyDto> re_reply;

    private String message;
    private LocalDateTime create_time;
    private LocalDateTime update_time;

    public ReplyDto(ReplyInfo info) {
        this.id = info.getId();
        this.writer_id = info.getWriter().getId();
        this.writer_nickname = info.getWriter().getNick_name();

        this.target_board_id = info.getTarget_board() == null ? -1L : info.getTarget_board().getId();
        this.target_reply_id = info.getTarget_reply() == null ? -1L : info.getTarget_reply().getId();

        this.message = info.getMessage();
        this.create_time = info.getCreateDateTime();
        this.update_time = info.getUpdateDateTime();
    }
    public ReplyDto(ReplyDto dto, List<ReplyDto> re_reply){
        this.id = dto.id;
        this.writer_id = dto.writer_id;
        this.writer_nickname = dto.writer_nickname;
        this.target_board_id = dto.target_board_id;
        this.target_reply_id = dto.target_reply_id;

        this.re_reply = re_reply;

        this.message = dto.message;
        this.create_time = dto.create_time;
        this.update_time = dto.update_time;
    }
}
