/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.entities.embeddedKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CleAuteursOuvrage implements Serializable {

    @Column(name = "auteur_id")
    private Long auteurId;

    @Column(name = "ouvrage_id")
    private Long ouvrageId;

    public CleAuteursOuvrage() {
    }

    public CleAuteursOuvrage(Long auteurId, Long ouvrageId) {
        this.auteurId = auteurId;
        this.ouvrageId = ouvrageId;
    }

    public Long getAuteurId() {
        return auteurId;
    }

    public void setAuteurId(Long auteurId) {
        this.auteurId = auteurId;
    }

    public Long getOuvrageId() {
        return ouvrageId;
    }

    public void setOuvrageId(Long ouvrageId) {
        this.ouvrageId = ouvrageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CleAuteursOuvrage that = (CleAuteursOuvrage) o;
        return Objects.equals(auteurId, that.auteurId) &&
                Objects.equals(ouvrageId, that.ouvrageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(auteurId, ouvrageId);
    }
}
