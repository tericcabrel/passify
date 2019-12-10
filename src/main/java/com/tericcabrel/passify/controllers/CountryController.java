package com.tericcabrel.passify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountryController {
    @GetMapping("/countries")
    public String list(Model model) {
        return "app/user/countries/list";
    }
}