package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Etudiant {
    @Id
    private String numEtu;
    @Column(name = "PRENOMETU")
    private String prenom;
    @Column(name = "NOMETU")
    private String nom;

    @ManyToMany(mappedBy = "inscrits")
    private Set<Formation> inscritEn;

    @ManyToMany
    @JoinTable(name = "MEMBRES",
            joinColumns = @JoinColumn(name = "IDMEMBRE"),
            inverseJoinColumns = @JoinColumn(name = "IDGROUPE"))
    private Set<Groupe> groupes;

    public Etudiant() {
    }

    public Etudiant(String numEtu, String prenom, String nom) {
        this.numEtu = numEtu;
        this.prenom = prenom;
        this.nom = nom;
    }
}
