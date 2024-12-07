package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

@Entity
public class Etudiant {
    @Id
    private String numEtu;
    private String prenom;
    private String nom;

    @ManyToMany(mappedBy = "inscrits")
    private Set<Formation> inscritEn;

    @ManyToMany
    private Set<Groupe> groupes;

    public Etudiant() {
    }

    public Etudiant(String numEtu, String prenom, String nom) {
        this.numEtu = numEtu;
        this.prenom = prenom;
        this.nom = nom;
    }
}
