package entities;

import jakarta.persistence.*;

@Entity
public class AvecTablePremiere {
    @TableGenerator(name = "tableAT",table = "TABLEAT",pkColumnName = "PKCOL",pkColumnValue = "PREMIERE")
    @Id @GeneratedValue(strategy = GenerationType.TABLE,generator = "tableAT")
    private int cle;

    public int getCle() {
        return cle;
    }}
