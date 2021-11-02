package com.capstone.kmcapstone.chatroom.controller;

import com.capstone.kmcapstone.chatroom.model.ChatRoom;
import com.capstone.kmcapstone.chatroom.model.ChatRoomForm;
import com.capstone.kmcapstone.chatroom.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/room")
public class ChatRoomController {
    private final ChatRoomRepository chatRoomRepository;

    @GetMapping("")
    public String rooms(Model model){
        model.addAttribute("rooms",chatRoomRepository.findAllRoom());
        return "room/rooms";
    }

    @GetMapping("/rooms/{id}")
    public String room(@PathVariable String id, Model model){
        ChatRoom room = chatRoomRepository.findRoomById(id);
        model.addAttribute("room",room);
        return "room/room";
    }

    @GetMapping("/new")
    public String make(Model model){
        ChatRoomForm form = new ChatRoomForm();
        model.addAttribute("form",form);
        return "room/newRoom";
    }

    @PostMapping("/new")
    public String makeRoom(ChatRoomForm form){
        System.out.println("진입");
        chatRoomRepository.createChatRoom(form.getName());
        System.out.println("레파지토리 사용");
        return "redirect:/room";
    }
}
