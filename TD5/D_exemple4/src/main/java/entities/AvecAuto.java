package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AvecAuto {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int cle;

    public int getCle() {
        return cle;
    }
}
