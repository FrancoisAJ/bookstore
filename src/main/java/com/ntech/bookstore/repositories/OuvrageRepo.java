/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.repositories;

import com.ntech.bookstore.entities.Ouvrage;
import com.ntech.bookstore.entities.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;

public interface OuvrageRepo extends CrudRepository<Ouvrage, Long> {

    Iterable<Ouvrage> findByTitre(String titre);

    Iterable<Ouvrage> findAllByCategorie(String categorie);

    Iterable<Ouvrage> findAllByTitreAndCategorie(String titre, String categorie);

//    Iterable<Ouvrage> findAllByTitreAndCategorie(String titre, String categorie);


}
