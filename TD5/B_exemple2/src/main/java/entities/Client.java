package entities;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Client extends Personne {
    private String numInsee;
    private LocalDate dateEmbauche;

    public String getNumInsee() {
        return numInsee;
    }

    public void setNumInsee(String numInsee) {
        this.numInsee = numInsee;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }
}
