/***
 ** Created By Francois ASSOGBA at 09/05/2019 for bookstore
 ***/

package com.ntech.bookstore.controllers;

import com.ntech.bookstore.configurations.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping
    public String index( ) {
//        Authentication authentication = authenticationFacade.getAuthentication();
//        if (authentication.isAuthenticated()){
//            return "home/homeSignedIn";
//        }
        return "home/home";
    }

    @GetMapping("home")
    public String home() {
        return "redirect:/";
    }
}
