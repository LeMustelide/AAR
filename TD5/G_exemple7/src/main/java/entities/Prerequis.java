package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @NoArgsConstructor
public class Prerequis {
    @Id @GeneratedValue
    private int idPrerequis;
    @ManyToOne
    @Setter
    private Matiere apres; // la matière quia un prérequis
    @ManyToOne
    @Setter
    private Matiere avant; // le prerequis
    @Setter
    private String raison;

    public Prerequis(Matiere apres, Matiere avant, String raison) {
        this.apres = apres;
        this.avant = avant;
        this.raison = raison;
    }
}
