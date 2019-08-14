/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.entities.embeddedKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CleLigneCommande implements Serializable {

    @Column(name = "commande_id")
    private Long commandeId;

    @Column(name = "ouvrage_id")
    private Long ouvrageId;

//    standard constructors, getters, and setters
    public CleLigneCommande(){
    }

    public Long getCommandeId() {
        return this.commandeId;
    }

    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }

    public Long getOuvrageId() {
        return this.ouvrageId;
    }

    public void setOuvrageId(Long ouvrageId) {
        this.ouvrageId = ouvrageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleLigneCommande that = (CleLigneCommande) o;
        return Objects.equals(getCommandeId(), that.getCommandeId()) &&
                Objects.equals(getOuvrageId(), that.getOuvrageId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCommandeId(), getOuvrageId());
    }

    //    hashcode and equals implementation
}
