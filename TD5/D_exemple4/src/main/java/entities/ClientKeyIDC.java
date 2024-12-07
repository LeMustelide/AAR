package entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

public class ClientKeyIDC implements Serializable {
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
        if ((obj instanceof ClientKeyIDC)==false) {
            return false;
        } else {
            ClientKeyIDC cki=(ClientKeyIDC) obj;
            return ((this.nom.equals(cki.getNom()))&& (this.prenom.equals(cki.getPrenom())));
        }
    }
}
