package com.capstone.kmcapstone.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String rootPage() {
        return "redirect:main";
    }


}
