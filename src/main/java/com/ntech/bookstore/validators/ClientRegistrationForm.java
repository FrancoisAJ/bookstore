/**
 * Created By
 * * asjoh
 * * at 13/05/2019
 * * with Joy
 * * for the bookstore project!
 **/

package com.ntech.bookstore.validators;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ClientRegistrationForm implements Serializable {

    @NotNull(message = "Ne doit pas être vide!")
    @Email(message = "Saisissez une email valide!")
    private String email;

    @NotNull
    @Pattern(regexp = "^(?=.*\\d).{8,32}$", message = "Au moins 8 caractères dont un caractère spécial.")
    private String password;

    @NotNull(message = "Ne doit pas être vide!")
    private String passwordConf;

    public ClientRegistrationForm() {

    }

    public ClientRegistrationForm(String email, String password, String passwordConf) {
        this.email = email;
        this.password = password;
        this.passwordConf = passwordConf;
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
}
