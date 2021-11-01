package com.capstone.kmcapstone.user.controller;

import com.capstone.kmcapstone.annotation.LoginUser;
import com.capstone.kmcapstone.user.dto.UserInfoDto;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.capstone.kmcapstone.user.service.UserService;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class UserPageController {

    private final UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping(value = "/api/user")
    public ModelAndView signup(
            UserInfoDto infoDto,
            ModelAndView model
    ) {
        model.setViewName("login");
        userService.save(infoDto);

        return model;
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
