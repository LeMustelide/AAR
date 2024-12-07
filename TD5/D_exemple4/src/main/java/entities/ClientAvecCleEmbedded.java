package entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ClientAvecCleEmbedded {
    @EmbeddedId
    private ClientKeyEmb key;

    public ClientAvecCleEmbedded() {
    }

    public ClientAvecCleEmbedded(String nom, String prenom) {
        this.key = new ClientKeyEmb();
        this.key.setNom(nom);
        this.key.setPrenom(prenom);
    }

    public ClientKeyEmb getKey() {
        return key;
    }

    public void setKey(ClientKeyEmb key) {
        this.key = key;
    }
}
