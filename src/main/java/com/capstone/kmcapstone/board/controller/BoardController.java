package com.capstone.kmcapstone.board.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.board.service.BoardPageService;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardPageService service;


    @PostMapping("")
    public HashMap<String, Object> createBoardDetail(
            BoardPageDto dto, @LoginUser UserInfo info
            ){

        return Maps.newHashMap(ImmutableMap.of(
                "id", service.createBoardDetail(dto, info)
        ));
    }
}
