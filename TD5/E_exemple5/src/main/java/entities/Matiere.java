package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Matiere {
    @Id
    private String idMatiere;
    private String intituleMatiere;
    @OneToMany(mappedBy = "apres")
    private List<Prerequis> necessite;
    @OneToMany(mappedBy = "avant")
    private List<Prerequis> prerequisDe;

    public Matiere() {
    }

    public Matiere(String idMatiere, String intituleMatiere) {
        this.idMatiere = idMatiere;
        this.intituleMatiere = intituleMatiere;
    }

    public String getIdMatiere() {
        return idMatiere;
    }

    public String getIntituleMatiere() {
        return intituleMatiere;
    }

    public void setIntituleMatiere(String intituleMatiere) {
        this.intituleMatiere = intituleMatiere;
    }

    public List<Prerequis> getNecessite() {
        return necessite;
    }

    public void setNecessite(List<Prerequis> necessite) {
        this.necessite = necessite;
    }

    public List<Prerequis> getPrerequisDe() {
        return prerequisDe;
    }

    public void setPrerequisDe(List<Prerequis> prerequisDe) {
        this.prerequisDe = prerequisDe;
    }
}
