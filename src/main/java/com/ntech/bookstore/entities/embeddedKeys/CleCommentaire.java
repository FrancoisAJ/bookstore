/***
 ** Created By Francois ASSOGBA at 08/05/2019 for bookstore
 ***/

package com.ntech.bookstore.entities.embeddedKeys;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CleCommentaire implements Serializable {

    @Column(name = "utilisateur_id")
    private Long utilisateurId;

    @Column(name = "ouvrage_id")
    private Long ouvrageId;

    public CleCommentaire() {
    }

    public CleCommentaire(Long utilisateurId, Long ouvrageId) {
        this.utilisateurId = utilisateurId;
        this.ouvrageId = ouvrageId;
    }

    public Long getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(Long utilisateurId) {
        this.utilisateurId = utilisateurId;
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
        CleCommentaire cleNote = (CleCommentaire) o;
        return Objects.equals(utilisateurId, cleNote.utilisateurId) &&
                Objects.equals(ouvrageId, cleNote.ouvrageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(utilisateurId, ouvrageId);
    }
}
