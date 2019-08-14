package com.ntech.bookstore.entities;

import com.ntech.bookstore.entities.embeddedKeys.CleCommentaire;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
//@Table(name = "Commentaire")
public class Commentaire implements Serializable {

	@EmbeddedId
	private CleCommentaire id;

	@Column(name = "libelle", nullable = false)
	private String libelle;

    @ManyToOne
    @MapsId("ouvrage_id")
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

    @ManyToOne
    @MapsId("utilisateur_id")
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Commentaire(){
    }

    public Commentaire(CleCommentaire id, String libelle, Ouvrage ouvrage, Utilisateur utilisateur) {
        this.id = id;
        this.libelle = libelle;
        this.ouvrage = ouvrage;
        this.utilisateur = utilisateur;
    }

    public CleCommentaire getId() {
        return id;
    }

    public void setId(CleCommentaire id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentaire that = (Commentaire) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(libelle, that.libelle) &&
                Objects.equals(ouvrage, that.ouvrage) &&
                Objects.equals(utilisateur, that.utilisateur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle, ouvrage, utilisateur);
    }
}
