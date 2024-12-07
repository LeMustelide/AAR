package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Prerequis {
    @Id @GeneratedValue
    private int idPrerequis;
    @ManyToOne
    private Matiere apres; // la matière quia un prérequis
    @ManyToOne
    private Matiere avant; // le prerequis
    private String raison;

    public Prerequis() {
    }

    public Prerequis(Matiere apres, Matiere avant, String raison) {
        this.apres = apres;
        this.avant = avant;
        this.raison = raison;
    }

    public int getIdPrerequis() {
        return idPrerequis;
    }

    public Matiere getApres() {
        return apres;
    }

    public void setApres(Matiere apres) {
        this.apres = apres;
    }

    public Matiere getAvant() {
        return avant;
    }

    public void setAvant(Matiere avant) {
        this.avant = avant;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }
}
