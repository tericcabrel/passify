package com.tericcabrel.passify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppAccountController {
    @GetMapping("/accounts")
    public String listAppAccount(Model model) {
        return "app/user/accounts/list";
    }

    @GetMapping("/accounts/create")
    public String createAppAccount(Model model) {
        return "app/user/accounts/create";
    }

    @GetMapping("/bank-accounts")
    public String listBankAccount(Model model) {
        return "app/user/bank-accounts/list";
    }

    @GetMapping("/bank-accounts/create")
    public String createBankAccount(Model model) {
        return "app/user/bank-accounts/create";
    }
}