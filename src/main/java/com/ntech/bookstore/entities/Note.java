package com.ntech.bookstore.entities;

import com.ntech.bookstore.entities.embeddedKeys.CleNote;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Table(name = "notes")
public class Note implements Serializable {

	@EmbeddedId
	private CleNote id;

	@Column(name = "note", nullable = false)
	private int note;

	@ManyToOne
	@MapsId("ouvrage_id")
	@JoinColumn(name = "ouvrage_id")
	private Ouvrage ouvrage;

	@ManyToOne
	@MapsId("utilisateur_id")
	@JoinColumn(name = "utilisateur_id")
	private Utilisateur utilisateur;

	public Note(){
    }

    public Note(CleNote id, int note, Ouvrage ouvrage, Utilisateur utilisateur) {
        this.id = id;
        this.note = note;
        this.ouvrage = ouvrage;
        this.utilisateur = utilisateur;
    }

    public CleNote getId() {
        return id;
    }

    public void setId(CleNote id) {
        this.id = id;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
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
}
