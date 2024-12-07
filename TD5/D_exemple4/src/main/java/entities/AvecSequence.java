package entities;

import jakarta.persistence.*;

@Entity
public class AvecSequence {
    @SequenceGenerator(name = "seqAS",sequenceName = "SEQAS")
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqAS")
    private int cle;

    public int getCle() {
        return cle;
    }
}
