package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
public class UFR {
    @Id @GeneratedValue
    private int idUFR;

    private String sigleUFR;

    @OneToMany(mappedBy = "GererPar")
    private Set<Batiment> batiments;

    public int getIdUFR() {
        return idUFR;
    }

    public String getSigleUFR() {
        return sigleUFR;
    }

    public void setSigleUFR(String sigleUFR) {
        this.sigleUFR = sigleUFR;
    }

    public Set<Batiment> getBatiments() {
        return batiments;
    }

    public void setBatiments(Set<Batiment> batiments) {
        this.batiments = batiments;
    }

    public UFR() {
    }
}
