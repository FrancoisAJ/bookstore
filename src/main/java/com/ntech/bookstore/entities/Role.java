package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Roles")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "libelle", length = 25, nullable = false, unique = true)
	private String libelle;

	@OneToMany(mappedBy = "role")
	private Set<Utilisateur> utilisateurs;

	public Role() {
	}

	public Role(String libelle) {
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

	@Override
	public String toString() {
		return "Role{" +
				"id=" + id +
				", libelle='" + libelle + '\'' +
				'}';
	}
}
