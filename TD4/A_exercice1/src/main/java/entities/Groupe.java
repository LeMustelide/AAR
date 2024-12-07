package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Groupe {
    @Id @GeneratedValue
    private int idGroupe;
    private String intitule;

    @ManyToMany
    private Set<Formation> etudiantsDe;

    @ManyToMany
    private Set<Etudiant> membres;

    @OneToMany(mappedBy = "concerne")
    private Set<Creneau> creneaux;

    public Groupe() {
    }
}
