/**
 * Created By
 * * asjoh
 * * at 13/05/2019
 * * with Joy
 * * for the bookstore project!
 **/

package com.ntech.bookstore.validators;

import javax.validation.constraints.*;
import java.io.Serializable;

public class EditorRegistrationForm implements Serializable {

    @NotNull(message = "Ne doit pas être vide!")
    @Email
    private String email;

    @NotNull(message = "Ne doit pas être vide!")
    @Pattern(regexp = "^(?=.*\\d).{8,32}$", message = "Au moins 8 caractères dont un caractère spécial.")
    private String password;

    @NotEmpty(message = "Ne doit pas être vide!")
    private String passwordConf;

    @NotNull
    @Size(min = 8, max = 13, message = "Téléphone invalide!")
    @Pattern(regexp = "^((\\+|00)229)?[269]{1}[0-9]{7}$", message = "Téléphone invalide!")
    private String telephone;

    public EditorRegistrationForm() {
    }

    public EditorRegistrationForm(String email, String password, String passwordConf) {
        this.email = email;
        this.password = password;
        this.passwordConf = passwordConf;
        this.telephone = "";
    }

    public EditorRegistrationForm(String email, String password, String passwordConf, String telephone) {
        this.email = email;
        this.password = password;
        this.passwordConf = passwordConf;
        this.telephone = telephone;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConf() {
        return passwordConf;
    }

    public void setPasswordConf(String passwordConf) {
        this.passwordConf = passwordConf;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
