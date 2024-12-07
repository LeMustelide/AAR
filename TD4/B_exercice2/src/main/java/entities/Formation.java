package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Formation {
    @Id @GeneratedValue
    @Column(name = "IDFORM")
    private int idFormation;
    @Column(name = "INTITULEFORM")
    private String intituleFormation;
    @ManyToMany
    private Set<Salle> reserve;
    @ManyToMany
    @JoinTable(name = "INSCRITS",
            joinColumns = @JoinColumn(name = "IDFORM"),
            inverseJoinColumns = @JoinColumn(name = "NUMETU"))
    private Set<Etudiant> inscrits;

    public Formation() {
    }
}
