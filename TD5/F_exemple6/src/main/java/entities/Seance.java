package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @NoArgsConstructor
public class Seance {
    @Id @GeneratedValue
    private int idSeance;
    @ManyToOne
    @Setter
    private Groupe groupe;
    @ManyToOne
    @Setter
    private Matiere matiere;
    @ManyToOne
    @Setter
    private Salle salle;
    @Setter
    private LocalDateTime debut;
    @Setter
    private LocalDateTime fin;


    public Seance(Groupe groupe, Matiere matiere, Salle salle, LocalDateTime debut, LocalDateTime fin) {
        this.groupe = groupe;
        this.matiere = matiere;
        this.salle = salle;
        this.debut = debut;
        this.fin = fin;
    }
}
