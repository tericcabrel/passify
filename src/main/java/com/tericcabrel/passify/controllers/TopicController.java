package com.tericcabrel.passify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TopicController {
    @GetMapping("/topics")
    public String list(Model model) {
        return "app/user/topics/list";
    }
}