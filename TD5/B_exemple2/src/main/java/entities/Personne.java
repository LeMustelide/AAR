package entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Personne {
    @Id @GeneratedValue
    private int idPers;
    private String nomPers;
    private String prenomPers;

    public int getIdPers() {
        return idPers;
    }

    public String getNomPers() {
        return nomPers;
    }

    public void setNomPers(String nomPers) {
        this.nomPers = nomPers;
    }

    public String getPrenomPers() {
        return prenomPers;
    }

    public void setPrenomPers(String prenomPers) {
        this.prenomPers = prenomPers;
    }
}
