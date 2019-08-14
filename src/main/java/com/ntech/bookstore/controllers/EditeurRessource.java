/***
 ** Created By Francois ASSOGBA at 09/05/2019 for bookstore
 ***/

package com.ntech.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/editor")
public class EditeurRessource {

    @GetMapping
    public String editeur() {
        return "editor";
    }

}
