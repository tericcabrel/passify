package com.tericcabrel.passify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppAccountController {
    @GetMapping("/accounts")
    public String list(Model model) {
        return "app/user/accounts/list";
    }

    @GetMapping("/accounts/create")
    public String create(Model model) {
        return "app/user/accounts/create";
    }
}