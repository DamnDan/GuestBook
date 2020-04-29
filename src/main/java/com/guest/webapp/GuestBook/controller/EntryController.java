package com.guest.webapp.GuestBook.controller;

import com.guest.webapp.GuestBook.entities.Entry;
import com.guest.webapp.GuestBook.repositories.EntryRepository;
import com.guest.webapp.GuestBook.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EntryController {
    private EntryService entryService;
    @Autowired
    public EntryController(EntryService entryService){
        this.entryService = entryService;
    }

    @RequestMapping("/")
        public String redirectDefault(){
            return "redirect:/all"; //instead of return "all";
        }

    @PostMapping("/all")
    public String entrySubmit(@ModelAttribute Entry entry) {
        System.out.println("entry");
        entryService.addEntry(entry);
        System.out.println("out");
        return "redirect:/all"; //instead of return "all";
    }

 @GetMapping("/all")
    public String getAllEntries(Model model) {
        model.addAttribute("entries", entryService.findAll()); //List for All Entries
        model.addAttribute("entry", new Entry()); //Object for Form
        return "all";
    }
    /*@GetMapping("/delete")
    public String deleteEntry(@RequestParam(name="id") int id){
        entryRepository.deleteById(id);
        return "redirect:/all"; //instead of return "all";
    }*/
}