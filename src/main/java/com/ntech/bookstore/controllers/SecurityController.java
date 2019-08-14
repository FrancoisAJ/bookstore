/**
 * Created By
 * * asjoh
 * * at 15/05/2019
 * * with Joy
 * * for the bookstore project!
 **/

package com.ntech.bookstore.controllers;

import com.ntech.bookstore.configurations.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecurityController{
        @Autowired
        private IAuthenticationFacade authenticationFacade;

//        @GetMapping("/username")
//        @ResponseBody
//        public String currentUserNameSimple() {
//            Authentication authentication = authenticationFacade.getAuthentication();
//            return authentication.getName();
//        }
}
