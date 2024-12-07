package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Creneau {
    @Id
    private int Creneau;
    @ManyToOne
    private Salle dans;
    @ManyToOne(optional = true)
    private Groupe concerne;

    private LocalDateTime debut;
    private LocalDateTime fin;

    public Creneau() {
    }
}
