/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.entities;

import com.ntech.bookstore.entities.embeddedKeys.CleLigneCommande;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "Lignes_Commande")
public class LignesCommande {

    @EmbeddedId
    private CleLigneCommande id;

    @Column(name = "quantite", nullable = false)
    private int quantite;

    @Column(name = "prixTTC", nullable = false)
    private Double prixTTC;

    @ManyToOne
    @MapsId("ouvrage_id")
    @JoinColumn(name = "ouvrage_id")
    private Ouvrage ouvrage;

    @ManyToOne
    @MapsId("commandes_id")
    @JoinColumn(name = "commandes_id")
    private Commande commande;

    public LignesCommande(){
    }

    public LignesCommande(int quantite, Double prixTTC, Ouvrage ouvrage, Commande commande) {
        this.quantite = quantite;
        this.prixTTC = prixTTC;
        this.ouvrage = ouvrage;
        this.commande = commande;
    }


    public CleLigneCommande getId() {
        return id;
    }

    public void setId(CleLigneCommande id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrixTTC() {
        return prixTTC;
    }

    public void setPrixTTC(Double prixTTC) {
        this.prixTTC = prixTTC;
    }

    public Ouvrage getOuvrage() {
        return ouvrage;
    }

    public void setOuvrage(Ouvrage ouvrage) {
        this.ouvrage = ouvrage;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LignesCommande that = (LignesCommande) o;
        return quantite == that.quantite &&
                Objects.equals(id, that.id) &&
                Objects.equals(prixTTC, that.prixTTC) &&
                Objects.equals(ouvrage, that.ouvrage) &&
                Objects.equals(commande, that.commande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantite, prixTTC, ouvrage, commande);
    }
}
