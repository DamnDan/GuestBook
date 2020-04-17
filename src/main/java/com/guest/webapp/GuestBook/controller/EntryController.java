package com.guest.webapp.GuestBook.controller;

import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EntryController {

    @Autowired
    private EntryRepository entryRepository;

    @RequestMapping("/")
        public String redirectDefault(){
            return "redirect:/all"; //instead of return "all";
        }

    @PostMapping("/all")
    public String entrySubmit(@ModelAttribute Entry entry) {
        System.out.println("entry");
        entryRepository.save(entry);
        System.out.println("out");
        return "redirect:/all"; //instead of return "all";
    }

}