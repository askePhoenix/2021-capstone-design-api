package com.capstone.kmcapstone.user.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.user.dto.UserInfoDto;
import com.capstone.kmcapstone.user.model.UserInfo;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserPageController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/main")
    public ModelAndView mainPage(
            ModelAndView model,
            @LoginUser UserInfo userInfo
            ) {
        model.setViewName("main");
        model.addObject("nick_name", userInfo.getNick_name());
        return model;
    }

    @GetMapping("/sign-on")
    public String signOnPage() {
        return "sign-on";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response,
                SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
