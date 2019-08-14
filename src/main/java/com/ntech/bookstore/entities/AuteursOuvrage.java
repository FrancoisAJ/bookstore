/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.entities;

import com.ntech.bookstore.entities.embeddedKeys.CleAuteursOuvrage;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
//@Table(name = "Auteurs_Ouvrage")
public class AuteursOuvrage {

    @EmbeddedId
    private CleAuteursOuvrage id;

    @Column(name = "date_ajout")
    private Date dateAjout;

    @ManyToOne
    @MapsId("ouvrage_id")
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

    @ManyToOne
    @MapsId("auteur_id")
    @JoinColumn(name = "auteur_id")
    private Auteur auteur;

    public AuteursOuvrage() {
    }

    public AuteursOuvrage(CleAuteursOuvrage id, Date dateAjout, Ouvrage ouvrage, Auteur auteur) {
        this.id = id;
        this.dateAjout = dateAjout;
        this.ouvrage = ouvrage;
        this.auteur = auteur;
    }

    public CleAuteursOuvrage getId() {
        return id;
    }

    public void setId(CleAuteursOuvrage id) {
        this.id = id;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public void setAuteur(Auteur auteur) {
        this.auteur = auteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuteursOuvrage that = (AuteursOuvrage) o;
        return Objects.equals(dateAjout, that.dateAjout);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateAjout);
    }
}
