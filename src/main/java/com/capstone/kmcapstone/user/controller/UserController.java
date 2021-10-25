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
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    private final UserService userService;


    @PostMapping(value = "")
    public HashMap<String, Object> signup(UserInfoDto infoDto) {
        Long id = userService.save(infoDto);
//            이미 이메일이 있는 경우
        if ( -1L == id ) return Maps.newHashMap(ImmutableMap.of("status", "fail" ));
        return Maps.newHashMap(ImmutableMap.of("create_user_id", id ));
    }
    @GetMapping(value = "/token")
    public HashMap<String, Object> getToken(CsrfToken token) {
        return Maps.newHashMap(ImmutableMap.of(
                "token", token
        ));
    }

}
