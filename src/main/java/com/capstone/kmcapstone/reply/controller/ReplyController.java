package com.capstone.kmcapstone.reply.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.reply.dto.ReplyDto;
import com.capstone.kmcapstone.reply.dto.ReplyVIewDto;
import com.capstone.kmcapstone.reply.service.ReplyService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards/")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService service;

    // 댓글 작성
    // /api/replys POST
    @PostMapping("{board}/replys")
    public ReplyDto createReply(
            @LoginUser UserInfo userInfo,
            ReplyVIewDto vIewDto,
            @PathVariable Long board) {
        return service.createReply(board, userInfo, vIewDto);
    }

    // 댓글 보기
    // /api/replys GET
    @GetMapping("{board}/replys")
    public List<ReplyDto> loadReplys(
            @PathVariable Long board
    ){
        return service.getReplys(board);
    }

    // 내가 작성한 댓글 전부 보기
    @GetMapping("replys/mine")
    public List<ReplyDto> loadReplysMine(
            @LoginUser UserInfo userInfo){
        return service.getReplysUser(userInfo);
    }

    // 댓글 수정
    // /api/replys/{reply} PUT
    @PutMapping("{board}/replys/{reply}")
    public ReplyDto putReplysMine(
            @LoginUser UserInfo userInfo,
            @PathVariable Long board,
            @PathVariable Long reply){
        return null;
    }

    // 댓글 삭제
    // /api/replys/{reply} DELETE

}
