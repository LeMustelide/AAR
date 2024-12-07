package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @NoArgsConstructor
public class Matiere {
    @Id
    private String idMatiere;
    @Setter
    private String intituleMatiere;
    @OneToMany(mappedBy = "apres")
    @Setter
    private List<Prerequis> necessite;
    @OneToMany(mappedBy = "avant")
    @Setter
    private List<Prerequis> prerequisDe;
    public Matiere(String idMatiere, String intituleMatiere) {
        this.idMatiere = idMatiere;
        this.intituleMatiere = intituleMatiere;
    }

}
