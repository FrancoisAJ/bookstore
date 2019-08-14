package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Ouvrage")
public class Ouvrage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "photo")
    private String photo;

    @Column(name = "lien", nullable = false)
    private String lien;

    @Column(name = "date_parution", nullable = false)
    private Date date_parution;

    @Column(name = "prix_unitaire", nullable = false)
    private double prix;

    @Column(name = "date_publication", nullable = false)
    private Date date_publication;

    @OneToMany(mappedBy = "ouvrage")
    Set<LignesCommande> lignesCommandes;

    @OneToMany(mappedBy = "ouvrage")
    Set<Note> notes;

    @ManyToOne
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne
    @JoinColumn(name = "devise_id")
    private Devise devise;

    @OneToMany(mappedBy = "ouvrage")
    Set<AuteursOuvrage> auteursOuvrages;


    public Ouvrage() {
    }

    public Ouvrage(String titre, String description, Date date_parution, double prix) {
        this.titre = titre;
        this.description = description;
        this.date_parution = date_parution;
        this.prix = prix;
    }

    public Ouvrage(String titre, String description, String isbn, String photo, String lien, Date date_parution,
                   double prix, Date date_publication) {
        this.titre = titre;
        this.description = description;
        this.isbn = isbn;
        this.date_parution = date_parution;
        this.prix = prix;
        this.date_publication = date_publication;
        this.lien = lien;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDate_parution() {
        return date_parution;
    }

    public void setDate_parution(Date date_parution) {
        this.date_parution = date_parution;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Devise getDevise() {
        return devise;
    }

    public void setDevise(Devise devise) {
        this.devise = devise;
    }

    public Set<AuteursOuvrage> getAuteursOuvrages() {
        return auteursOuvrages;
    }

    public void setAuteursOuvrages(Set<AuteursOuvrage> auteursOuvrages) {
        this.auteursOuvrages = auteursOuvrages;
    }

    public Date getDate_publication() {
        return date_publication;
    }

    public void setDate_publication(Date date_publication) {
        this.date_publication = date_publication;
    }

    public Set<LignesCommande> getLignesCommandes() {
        return lignesCommandes;
    }

    public void setLignesCommandes(Set<LignesCommande> lignesCommandes) {
        this.lignesCommandes = lignesCommandes;
    }
}
