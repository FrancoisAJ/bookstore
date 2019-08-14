/**
 * Created By
 * * asjoh
 * * at 15/05/2019
 * * with Joy
 * * for the bookstore project!
 **/

package com.ntech.bookstore.controllers;

import com.ntech.bookstore.entities.Ouvrage;
import com.ntech.bookstore.services.OuvrageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OuvragesController {

    @Autowired
    OuvrageService ouvrageService;

    @GetMapping("/books")
    public String books(Model model) {
        List<Ouvrage> ouvrageList = ouvrageService.getAllOuvrages();
        model.addAttribute("books", ouvrageList);
        return "books/index";
    }

}
