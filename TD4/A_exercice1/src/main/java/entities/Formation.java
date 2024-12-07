package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Formation {
    @Id @GeneratedValue
    private int idFormation;
    private String intituleFormation;
    @ManyToMany
    private Set<Salle> reserve;
    @ManyToMany
    private Set<Etudiant> inscrits;

    public Formation() {
    }
}
