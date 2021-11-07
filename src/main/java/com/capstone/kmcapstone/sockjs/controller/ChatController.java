package com.capstone.kmcapstone.sockjs.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.sockjs.room.ChatRoom;
import com.capstone.kmcapstone.sockjs.room.RoomForm;
import com.capstone.kmcapstone.sockjs.service.ChatService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
//@RequestMapping("/room")
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;


    @GetMapping("/room")
    public String allRooms(Model model) {
        model.addAttribute("rooms",chatService.findAllRoom());
        return "/room/rooms";
    }

    @GetMapping("/room/{id}")
    public String join(@PathVariable String id, Model model , @LoginUser UserInfo userInfo) {

        model.addAttribute("room", chatService.findRoomById(id));
        return "/room/room";
    }


    @GetMapping("/room/new")
    public String getNew(Model model) {
        log.info("get,new");
        RoomForm form = new RoomForm();
        model.addAttribute("form", form);
        return "/room/newRoom";
    }

    @PostMapping(value = "/room/new")
    public String createRoom(RoomForm form) {
        log.info("post create ");
        chatService.createRoom(form.getName());
        return "redirect:/room";
    }


}
