package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Commandes")
public class Commande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date_commande", nullable = false)
    private Date date_commande;

    @Column(name = "montant_total", nullable = false)
    private double montant_total;

    @Column(name = "ref_commande", nullable = false)
    private String ref_commande;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "commande")
    Set<LignesCommande> lignesCommandes;

    public Commande() {
    }

    public Commande(Date date_commande, double montant_total, String ref_commande) {
        this.date_commande = date_commande;
        this.montant_total = montant_total;
        this.ref_commande = ref_commande;
    }
}
