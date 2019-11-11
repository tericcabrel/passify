package com.tericcabrel.passify.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NoteController {
    @GetMapping("/note-groups")
    public String noteGroups(Model model) {
        return "app/user/notes/group-list";
    }

    @GetMapping("/notes")
    public String notes(
            @RequestParam(name = "groupName", required = false, defaultValue = "all") String noteGroupName,
            Model model
    ) {
        System.out.println("Note group name => " + noteGroupName);

        return "app/user/notes/list";
    }

    @GetMapping("/notes/create")
    public String createNote(@RequestParam(name = "groupId", required = false) String noteGroupId, Model model) {
        System.out.println("Note group Id => " + noteGroupId);

        return "edit";
    }

    @GetMapping("/notes/{id}")
    public String updateNote(@PathVariable(value = "id") Long noteId, Model model) {
        System.out.println("Note id => " + noteId);
        return "edit";
    }
}