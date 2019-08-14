package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Categorie")
public class Categorie implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	@OneToMany(mappedBy = "categorie")
    private Set<Ouvrage> ouvrages;

    public Categorie() {
    }

    public Categorie(String libelle) {
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

    public Set<Ouvrage> getOuvrages() {
        return ouvrages;
    }

    public void setOuvrages(Set<Ouvrage> ouvrages) {
        this.ouvrages = ouvrages;
    }
}
