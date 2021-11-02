package com.capstone.kmcapstone.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {

    @GetMapping("/chatting")
    public String chat() {
        return "chat/chat";
    }

}
