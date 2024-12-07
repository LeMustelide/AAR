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
    @JoinTable(name = "MEMBRES",
            joinColumns = @JoinColumn(name = "IDGROUPE"),
            inverseJoinColumns = @JoinColumn(name = "NUMETU"))
    private Set<Etudiant> membres;

    @OneToMany(mappedBy = "concerne")
    private Set<Creneau> creneaux;

    public Groupe() {
    }
}
