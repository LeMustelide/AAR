package entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Groupe {
    @Id @GeneratedValue
    private int idGroupe;
    @Setter
    private String libelleGroupe;
    @Setter
    private int tailleGroupe;
    @ManyToMany
    @JoinTable(name = "suit")
    @Setter
    private Set<Matiere> suit;


    public Groupe(int idGroupe, String libelleGroupe, int tailleGroupe) {
        this.idGroupe = idGroupe;
        this.libelleGroupe = libelleGroupe;
        this.tailleGroupe = tailleGroupe;
    }
}
