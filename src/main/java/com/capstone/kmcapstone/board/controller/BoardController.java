package com.capstone.kmcapstone.board.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.board.dto.BoardPageableDto;
import com.capstone.kmcapstone.board.dto.RecommendDto;
import com.capstone.kmcapstone.board.service.BoardPageService;
import com.capstone.kmcapstone.board.service.RecommendBoardService;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardPageService service;
    private final RecommendBoardService recommendBoardService;


    // 게시판 글 작성하기
    @PostMapping("")
    public HashMap<String, Object> createBoardDetail(
            BoardPageDto dto, @LoginUser UserInfo info
    ) {

        return Maps.newHashMap(ImmutableMap.of(
                "id", service.createBoardDetail(dto, info)
        ));
    }

    // 게시판 테이블 가져오기
    @GetMapping("")
    public BoardPageableDto loadTable(
            @RequestParam("page") Integer page, @RequestParam("size") Integer size
    ) {
        return service.getPage(page, size);
    }


    // 게시글 추천하기
    // url : {board}/recommend
    @PostMapping("{board}/recommend")
    public RecommendDto giveRecommend(
            @LoginUser UserInfo userInfo,
            @PathVariable Long board
    ) {
        return new RecommendDto(recommendBoardService.giveRecommend(board, userInfo));
    }

    // 게시글 추천수 가져오기
    @GetMapping("{board}/recommend")
    public RecommendDto loadRecommend(
            @PathVariable Long board
    ) {
        return new RecommendDto(recommendBoardService.loadRecommend(board));
    }
}
