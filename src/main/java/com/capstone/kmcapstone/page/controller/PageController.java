package com.capstone.kmcapstone.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("main")
    public String mainPage() {
        return "main";
    }

    @GetMapping("sign-on")
    public String signOnPage() {
        return "sign-on";
    }

    @GetMapping("")
    public String rootPage() {
        return "redirect:main";
    }


}
