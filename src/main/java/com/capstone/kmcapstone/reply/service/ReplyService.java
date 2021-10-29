package com.capstone.kmcapstone.reply.service;

import com.capstone.kmcapstone.reply.dto.ReplyDto;
import com.capstone.kmcapstone.reply.dto.ReplyVIewDto;
import com.capstone.kmcapstone.user.model.UserInfo;

import java.util.List;

public interface ReplyService {
    // 댓글 생성하기
    ReplyDto createReply(Long target_board, UserInfo userInfo, ReplyVIewDto vIewDto);

    // 게시글 댓글 전부 가져오기
    List<ReplyDto> getReplys(Long target_board);

    // 내가 작성한 댓글,  보기
    List<ReplyDto> getReplysUser(UserInfo userInfo);
}
