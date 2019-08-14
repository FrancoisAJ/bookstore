/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Cat_Socio_Prof")
public class CatSocioProf implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "libelle", length = 25, nullable = false, unique = true)
    private String libelle;

    @OneToMany(mappedBy = "catSocioProf")
    private Set<Utilisateur> utilisateurs;


    public CatSocioProf() {
    }
    public CatSocioProf(String libelle) {
        this.libelle = libelle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
