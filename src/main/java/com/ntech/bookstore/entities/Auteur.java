package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Auteurs")
public class Auteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    @Column(name = "nom", nullable = false, length = 25)
	private String nom;
    @Column(name = "prenom", nullable = false, length = 30)
	private String prenom;

    @Column(name = "civilite", length = 12)
    private String civilite;

    @Column(name = "sexe", nullable = false, length = 8)
    private char Sexe;

    @Column(name = "nationnalite", nullable = false)
	private String nationnalite;

    @OneToMany(mappedBy = "auteur")
    Set<AuteursOuvrage> auteursOuvrages;

    public Auteur(){}

    public Auteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Auteur(String nom, String prenom, String civilite, char sexe, String nationnalite) {
        this.nom = nom;
        this.prenom = prenom;
        this.civilite = civilite;
        Sexe = sexe;
        this.nationnalite = nationnalite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public char getSexe() {
        return Sexe;
    }

    public void setSexe(char sexe) {
        Sexe = sexe;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public Set<AuteursOuvrage> getAuteursOuvrages() {
        return auteursOuvrages;
    }

    public void setAuteursOuvrages(Set<AuteursOuvrage> auteursOuvrages) {
        this.auteursOuvrages = auteursOuvrages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auteur auteur = (Auteur) o;
        return Sexe == auteur.Sexe &&
                Objects.equals(nom, auteur.nom) &&
                Objects.equals(prenom, auteur.prenom) &&
                Objects.equals(nationnalite, auteur.nationnalite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom, Sexe, nationnalite);
    }
}
