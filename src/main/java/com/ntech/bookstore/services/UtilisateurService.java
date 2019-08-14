/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/
package com.ntech.bookstore.services;

import com.ntech.bookstore.entities.Utilisateur;
import com.ntech.bookstore.repositories.RolesRepo;
import com.ntech.bookstore.repositories.UtilisateurRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class UtilisateurService implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UtilisateurService.class);

    @Autowired
    private UtilisateurRepo userRepository;

    @Autowired
    private RolesRepo rolesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = userRepository.findByEmail(email);
        if (utilisateur != null) {
            return new User(
                    email, utilisateur.getPassword(),
                    true, true, true, true,
                    utilisateur.getAuthorities()
            );
        } else {
            LOGGER.info("Nothing Found!");
            return null;
        }
    }

    public Utilisateur findUserByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public void save(Utilisateur user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<Utilisateur> getAllUsers() {

        List<Utilisateur> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users;
    }

    public void removeUser(Utilisateur utilisateur) {
        if (userRepository.findById(utilisateur.getId()) != null) {
            userRepository.delete(utilisateur);
        }
    }
    public void removeUserByEmail(String email) {
        if (userRepository.findByEmail(email) != null) {
            userRepository.removeByEmail(email);
        }
    }

    public void desableUser(Utilisateur utilisateur) {
        if (userRepository.findById(utilisateur.getId()) != null) {
            utilisateur.desable();
            userRepository.save(utilisateur);
        }
    }

    public void activateUser(Utilisateur utilisateur) {
        if (userRepository.findById(utilisateur.getId()) != null) {
            utilisateur.activate();
            userRepository.save(utilisateur);
        }
    }


}
