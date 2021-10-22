package com.capstone.kmcapstone.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/boards")
public class BoardPageController {

    @GetMapping("")
    public String getBoard(){
        return "/board/board";
    }

    @GetMapping("/{board}")
    public ModelAndView getBoardDetail(
            ModelAndView model,
            @PathVariable Long board
    ){
        model.setViewName("board/detail/board_detail");
        model.addObject("title", "제목입니다.");
        model.addObject("contents", "내용입니다.");
        model.addObject("writer", "작성자 성명입니다.");
        model.addObject("message", "메시지 입니다.");
        return model;
    }
}
