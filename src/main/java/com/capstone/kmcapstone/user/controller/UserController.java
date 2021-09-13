package com.capstone.kmcapstone.user.controller;

import com.capstone.kmcapstone.user.dto.UserInfoDto;
import com.capstone.kmcapstone.user.service.UserService;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-on")
    public HashMap<String, Object> signOnUser(){
        return null;
    }

    @PostMapping(value = "")
    public HashMap<String, Object> signup(UserInfoDto infoDto) {
        Long id = userService.save(infoDto);
//            이미 이메일이 있는 경우
        if ( -1L == id ) return Maps.newHashMap(ImmutableMap.of("status", "fail" ));
        return Maps.newHashMap(ImmutableMap.of("create_user_id", id ));
    }
}
