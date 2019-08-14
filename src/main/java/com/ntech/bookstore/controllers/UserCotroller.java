/***
 ** Created By Francois ASSOGBA at 09/05/2019 for bookstore
 ***/

package com.ntech.bookstore.controllers;

import com.ntech.bookstore.entities.Utilisateur;
import com.ntech.bookstore.services.UtilisateurService;
import com.ntech.bookstore.validators.ClientRegistrationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserCotroller {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/admin/users")
    public String users(Model model) {
        List<Utilisateur> users = utilisateurService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin/users/{email}")
    public String user(Model model, @PathVariable String email) {
        Utilisateur users = utilisateurService.findUserByEmail(email);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/admin/users/r/{email}")
    public String removeUser(Model model, @PathVariable String email) {
        utilisateurService.removeUserByEmail(email);
        return "users";
    }

//    @PostMapping("/admin/users/u/email")
//    public String updateUser(@ModelAttribute @Valid ClientRegistrationForm clientRegistrationForm,
//                                           Errors errors, Model model) {
//        if (errors.hasErrors()) {
//            LOGGER.info("Error in the form");
//            model.addAttribute("error", "Veuillez corriger les erreurs!");
//            return "auth/clientSignup";
//        }
//        if (userRepository.findByEmail(clientRegistrationForm.getEmail()) != null) {
//            model.addAttribute("error", "Cet email est déjà utilisé!");
//            return "auth/clientSignup";
//        }
//        if(!clientRegistrationForm.getPassword().equals(clientRegistrationForm.getPasswordConf())){
//            model.addAttribute("error", "Différents mots de passe!");
//            return "auth/clientSignup";
//        }
//        Utilisateur utilisateur = new Utilisateur();
//        utilisateur.setEmail(clientRegistrationForm.getEmail());
//        utilisateur.setPassword(passwordEncoder.encode(clientRegistrationForm.getPassword()));
//        utilisateur.setRole(roleRepository.findById(2));
//        utilisateur.activate();
//        userRepository.save(utilisateur);
//        LOGGER.info("Good form | User saved!");
//        return "redirect:/home";
//    }



}
