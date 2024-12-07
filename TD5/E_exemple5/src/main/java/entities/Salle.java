package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Salle {
    @Id
    private int idSalle;
    private String nomSalle;
    private int capacite;

    public Salle(){}

    public Salle(String nomSalle, int capacite) {
        this.nomSalle = nomSalle;
        this.capacite = capacite;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public String getNomSalle() {
        return nomSalle;
    }

    public void setNomSalle(String nomSalle) {
        this.nomSalle = nomSalle;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }
}
