package entities;

import jakarta.persistence.*;

@Entity
public class Adresse {
    @Id @GeneratedValue
    private int idAdresse;
    private String rue;
    private String codepostal;
    private String ville;
    @ManyToOne
    @JoinColumn(name = "CODEPAYS")
    private Pays pays;

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public int getIdAdresse() {
        return idAdresse;
    }

    public String getRue() {
        return rue;
    }

    public String getCodepostal() {
        return codepostal;
    }

    public String getVille() {
        return ville;
    }

    public Pays getPays() {
        return pays;
    }
}
