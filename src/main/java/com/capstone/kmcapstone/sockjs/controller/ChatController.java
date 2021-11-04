package com.capstone.kmcapstone.sockjs.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/sockjs")
public class ChatController {
    @GetMapping("/chat")
    public void chatGet() {
        log.info("@ChatController,chat Get()");

    }
}
