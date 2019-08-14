/**
 * Created By
 * * asjoh
 * * at 15/05/2019
 * * with Joy
 * * for the bookstore project!
 **/

package com.ntech.bookstore.services;

import com.ntech.bookstore.entities.Ouvrage;
import com.ntech.bookstore.repositories.OuvrageRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OuvrageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OuvrageService.class);

    @Autowired
    private OuvrageRepo ouvrageRepository;


    public void save(Ouvrage ouvrage) {
        ouvrageRepository.save(ouvrage);
    }

    public List<Ouvrage> getAllOuvrages() {

        List<Ouvrage> ouvrageList = new ArrayList<>();
        ouvrageRepository.findAll()
                .forEach(ouvrageList::add);
        return ouvrageList;
    }

    public void removeOuvrage(Ouvrage ouvrage) {
        if (ouvrageRepository.findById(ouvrage.getId()) != null) {
            ouvrageRepository.delete(ouvrage);
        }
    }

    public void removeOuvrage(long id) {
        ouvrageRepository.deleteById(id);
    }

    public List<Ouvrage> findOuvragesByTitre(String titre) {
        Iterable<Ouvrage> ouvrages = ouvrageRepository.findByTitre(titre);
        if (ouvrages == null) {
            return null;
        }
        List<Ouvrage> ouvrageList = new ArrayList<>();
        ouvrages.forEach(ouvrageList::add);
        return ouvrageList;
    }

    public List<Ouvrage> findOuvragesByCategorie(String categorie) {
        Iterable<Ouvrage> ouvrages = ouvrageRepository.findAllByCategorie(categorie);
        if (ouvrages == null) {
            return null;
        }
        List<Ouvrage> ouvrageList = new ArrayList<>();
        ouvrages.forEach(ouvrageList::add);
        return ouvrageList;
    }


}
