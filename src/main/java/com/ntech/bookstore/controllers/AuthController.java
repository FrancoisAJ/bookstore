/***
 ** Created By Francois ASSOGBA at 09/05/2019 for bookstore
 ***/

package com.ntech.bookstore.controllers;

import com.ntech.bookstore.entities.Utilisateur;
import com.ntech.bookstore.repositories.RolesRepo;
import com.ntech.bookstore.repositories.UtilisateurRepo;
import com.ntech.bookstore.validators.ClientRegistrationForm;
import com.ntech.bookstore.validators.EditorRegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AuthController  {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UtilisateurRepo userRepository;

    @Autowired
    RolesRepo roleRepository;


    @GetMapping("/login")
    public String getLogin() {
        return "auth/login";
    }

    @GetMapping(value = "/login?error")
    public String getLoginErr(String error, Model model) {
        model.addAttribute("error", "error");
        return "auth/login";
    }

    @PostMapping("/login")
    public String postLogin() {
        return "home";
    }

    @GetMapping("/logout")
    public String logout() {
        return "auth/login";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "errors/403";
    }

    @GetMapping("/signup")
    public String showRegistrationPage() {
        return "auth/signup";
    }

    @GetMapping("/signup/client")
    public String showClientRegistrationForm(Model model) {
        model.addAttribute(new ClientRegistrationForm());
        return "auth/clientSignup";
    }

    @PostMapping("/signup/client")
    public String handleClientRegistration(@ModelAttribute @Valid ClientRegistrationForm clientRegistrationForm,
                                           Errors errors, Model model) {
        if (errors.hasErrors()) {
            LOGGER.info("Error in the form");
            model.addAttribute("error", "Veuillez corriger les erreurs!");
            return "auth/clientSignup";
        }
        if (userRepository.findByEmail(clientRegistrationForm.getEmail()) != null) {
            model.addAttribute("error", "Cet email est déjà utilisé!");
            return "auth/clientSignup";
        }
        if(!clientRegistrationForm.getPassword().equals(clientRegistrationForm.getPasswordConf())){
            model.addAttribute("error", "Différents mots de passe!");
            return "auth/clientSignup";
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(clientRegistrationForm.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(clientRegistrationForm.getPassword()));
        utilisateur.setRole(roleRepository.findById(2));
        utilisateur.activate();
        userRepository.save(utilisateur);
        LOGGER.info("Good form | User saved!");
        return "redirect:/home";
    }


    @GetMapping("/signup/editor")
    public String showEditorRegistrationForm(Model model) {
        model.addAttribute(new EditorRegistrationForm());
        return "auth/editorSignup";
    }


    @PostMapping("/signup/editor")
    public String handleEditorRegistration(@ModelAttribute @Valid EditorRegistrationForm editorRegistrationForm ,
                                           Errors errors, Model model) {
        if (errors.hasErrors()) {
            LOGGER.info("Error in the form");
            model.addAttribute("error", "Veuillez corriger les erreurs!");
            return "auth/editorSignup";
        }
        if (userRepository.findByEmail(editorRegistrationForm.getEmail()) != null) {
            model.addAttribute("error", "Cet email est déjà utilisé!");
            return "auth/editorSignup";
        }
        if(!editorRegistrationForm.getPassword().equals(editorRegistrationForm.getPasswordConf())){
            model.addAttribute("error", "Différents mots de passe!");
            return "auth/editorSignup";
        }
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(editorRegistrationForm.getEmail());
        utilisateur.setPassword(passwordEncoder.encode(editorRegistrationForm.getPassword()));
        utilisateur.setRole(roleRepository.findById(2));
        utilisateur.activate();
        utilisateur.setTelephone(editorRegistrationForm.getTelephone());
        userRepository.save(utilisateur);
        LOGGER.info("Good form | User saved!");
        return "home/homeSignedIn";
    }
}
