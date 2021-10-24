package com.capstone.kmcapstone.board.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.board.dto.BoardPageDto;
import com.capstone.kmcapstone.board.service.BoardPageService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardPageController {
    private final BoardPageService service;

    @GetMapping("")
    public String getBoard() {
        return "/board/board";
    }

    @GetMapping("/{board}")
    public ModelAndView getBoardDetail(
            ModelAndView model,
            @PathVariable Long board
    ) {
        final BoardPageDto dto = service.loadBoardDetail(board);
        model.setViewName("board/detail/board_detail");


        if (dto.getId() == -1L) {
            model.addObject("title", "존재하지 않는 게시글입니다.");
            model.addObject("contents", "존재하지 않는 게시글입니다.");
            model.addObject("writer", "존재하지 않는 게시글입니다.");
            model.addObject("message", "404-not found");
        } else {
            model.addObject("title", dto.getTitle());
            model.addObject("contents", dto.getContents());
            model.addObject("writer", dto.getWriter_name());
            model.addObject("message", "message");
        }

        return model;
    }

    @GetMapping("/write")
    public ModelAndView getBoardWrite(
            ModelAndView model,
            @LoginUser UserInfo userInfo
    ) {
        model.setViewName("board/write/board_write");
        model.addObject("writer", userInfo.getNick_name());
        return model;
    }
}
