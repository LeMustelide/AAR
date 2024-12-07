package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Seance {
    @Id @GeneratedValue
    private int idSeance;
    @ManyToOne
    private Groupe groupe;
    @ManyToOne
    private Matiere matiere;
    @ManyToOne
    private Salle salle;
    private LocalDateTime debut;
    private LocalDateTime fin;

    public Seance() {
    }

    public Seance(Groupe groupe, Matiere matiere, Salle salle, LocalDateTime debut, LocalDateTime fin) {
        this.groupe = groupe;
        this.matiere = matiere;
        this.salle = salle;
        this.debut = debut;
        this.fin = fin;
    }


    public int getIdSeance() {
        return idSeance;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }
}
