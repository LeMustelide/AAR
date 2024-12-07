package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @NoArgsConstructor
public class Salle {
    @Id
    private int idSalle;
    @Setter
    private String nomSalle;
    @Setter
    private int capacite;

    public Salle(String nomSalle, int capacite) {
        this.nomSalle = nomSalle;
        this.capacite = capacite;
    }
}
