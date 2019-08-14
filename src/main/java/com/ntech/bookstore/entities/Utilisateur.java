package com.ntech.bookstore.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Utilisateurs")
public class Utilisateur implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom", length = 25)
    private String nom;

    @Column(name = "prenom", length = 30)
    private String prenom;

    @Column(name = "email", nullable = false, unique = true, length = 25)
    private String email;

    @Column(name = "addresse", length = 50)
    private String addresse;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "telephone", length = 40)
    private String telephone;

    @Column(name = "nationnalite", length = 25)
    private String nationnalite;

    @Column(name = "civilite", length = 12)
    private String civilite;

    @Column(name = "active", length = 1, nullable = false)
    private Boolean active;

    @Column(name = "date_naissance")
    private Date date_naissance;

    @Column(name = "photo")
    private String photo;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "Cat_Socio_Prof_id")
    private CatSocioProf catSocioProf;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Log> logs;

    @OneToMany(mappedBy = "utilisateur")
    private Set<Commande> commandes;

    @OneToMany(mappedBy = "utilisateur")
    Set<Note> notes;




    public Utilisateur() {
    }

    public Utilisateur(String email, String password, String telephone) {
        this.email = email;
        this.password = password;
        this.telephone = telephone;
    }

    public Utilisateur(String nom, String prenom, String email, String addresse,
                       String password, String telephone, String nationnalite,
                       String civilite, Boolean active, Date date_naissance, String photo) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.addresse = addresse;
        this.password = password;
        this.telephone = telephone;
        this.nationnalite = nationnalite;
        this.civilite = civilite;
        this.active = active;
        this.date_naissance = date_naissance;
        this.photo = photo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddresse() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse = addresse;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Boolean isActive() {
        return active;
    }

    public void toggleActive() {
        this.active = !this.active;
    }

    public void activate() {
        this.active = true;
    }

    public void desable() {
        this.active = false;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public CatSocioProf getCatSocioProf() {
        return catSocioProf;
    }

    public void setCatSocioProf(CatSocioProf catSocioProf) {
        this.catSocioProf = catSocioProf;
    }

    public Set<Log> getLogs() {
        return logs;
    }

    public void setLogs(Set<Log> logs) {
        this.logs = logs;
    }

    public Set<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(Set<Commande> commandes) {
        this.commandes = commandes;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(telephone, that.telephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, telephone);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(this.getRole().getLibelle());
        return authorities;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }


}
