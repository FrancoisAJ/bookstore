/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.repositories;

import com.ntech.bookstore.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepo extends CrudRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String email);

    void removeByEmail(String email);

}
