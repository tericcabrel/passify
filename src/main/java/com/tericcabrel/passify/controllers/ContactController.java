package com.tericcabrel.passify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class ContactController {
    @GetMapping("/contacts")
    public String list(Model model) {
        return "app/user/contacts/list";
    }

    @GetMapping("/contacts/create")
    public String create(Model model) {
        return "app/user/contacts/create";
    }
}