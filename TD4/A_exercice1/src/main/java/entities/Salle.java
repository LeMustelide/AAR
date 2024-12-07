package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class Salle {
    @Id
    private String numSalle;
    private int capacite;
    @OneToMany(mappedBy = "dans")
    private Set<Creneau> occupations;
    @ManyToMany(mappedBy = "reserve")
    private Set<Formation> reserveeA;

    public Salle() {
    }
}
