package entities;

import jakarta.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Employe extends Personne{
    private String email;
    private LocalDate dateAnniversaire;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateAnniversaire() {
        return dateAnniversaire;
    }

    public void setDateAnniversaire(LocalDate dateAnniversaire) {
        this.dateAnniversaire = dateAnniversaire;
    }
}
