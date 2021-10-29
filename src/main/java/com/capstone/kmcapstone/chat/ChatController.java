package com.capstone.kmcapstone.chat;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.user.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatController {

    @GetMapping("/chatting")
    public ModelAndView getChat(ModelAndView model , @LoginUser UserInfo userInfo) {
        model.setViewName("/chat/chat");
        model.addObject("userid",userInfo.getNick_name());
        return model;
    }

}
