package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Batiment {
    @Id @GeneratedValue
    private int idBatiment;

    private String nomBatiment;

    @ManyToOne(optional = true)
    private UFR GererPar;

    @OneToMany
    private Set<Salle> salles;

    public Batiment() {
    }
}
