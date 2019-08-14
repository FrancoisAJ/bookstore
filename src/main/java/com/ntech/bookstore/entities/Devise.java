package com.ntech.bookstore.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Devises")
public class Devise implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code", nullable = false)
	private String code;

	@Column(name = "libelle", nullable = false)
	private String libelle;

	@OneToMany(mappedBy = "devise")
	private Set<Ouvrage> ouvrages;

	public Devise(){}

    public Devise(String code, String libelle) {
	    this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devise devise = (Devise) o;
        return Objects.equals(code, devise.code) &&
                Objects.equals(libelle, devise.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, libelle);
    }
}
