package entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Groupe {
    @Id @GeneratedValue
    private int idGroupe;
    private String libelleGroupe;
    private int tailleGroupe;
    @ManyToMany
    @JoinTable(name = "suit")
    private Set<Matiere> suit;

    public Groupe(){}

    public Groupe(int idGroupe, String libelleGroupe, int tailleGroupe) {
        this.idGroupe = idGroupe;
        this.libelleGroupe = libelleGroupe;
        this.tailleGroupe = tailleGroupe;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public String getLibelleGroupe() {
        return libelleGroupe;
    }

    public void setLibelleGroupe(String libelleGroupe) {
        this.libelleGroupe = libelleGroupe;
    }

    public int getTailleGroupe() {
        return tailleGroupe;
    }

    public void setTailleGroupe(int tailleGroupe) {
        this.tailleGroupe = tailleGroupe;
    }

    public Set<Matiere> getSuit() {
        return suit;
    }

    public void setSuit(Set<Matiere> suit) {
        this.suit = suit;
    }
}
