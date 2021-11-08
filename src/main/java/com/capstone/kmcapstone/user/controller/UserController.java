package com.capstone.kmcapstone.user.controller;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @GetMapping(value = "/token")
    public HashMap<String, Object> getToken(CsrfToken token) {
        return Maps.newHashMap(ImmutableMap.of(
                "token", token
        ));
    }

}
