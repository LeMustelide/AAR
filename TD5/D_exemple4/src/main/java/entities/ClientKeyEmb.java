package entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
public class ClientKeyEmb implements Serializable {
    private String nom;
    private String prenom;

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

    @Override
    public int hashCode() {
        String np=nom+prenom;
        return np.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof ClientKeyEmb)==false) {
            return false;
        } else {
            ClientKeyEmb cke=(ClientKeyEmb) obj;
            return ((this.nom.equals(cke.getNom()))&& (this.prenom.equals(cke.getPrenom())));
        }
    }
}
