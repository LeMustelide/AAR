package entities;

import jakarta.persistence.*;

@Entity
public class AvecTableSeconde {
    @TableGenerator(name = "tableAT",table = "TABLEAT",pkColumnName = "PKCOL",pkColumnValue = "SECONDE")
    @Id @GeneratedValue(strategy = GenerationType.TABLE,generator = "tableAT")
    private int cle;

    public int getCle() {
        return cle;
    }}
