package entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
public class Membre {
    @Id @GeneratedValue
    private int idMembre;
    private String nomMembre;
    @OneToMany(mappedBy = "modificateur")
    private List<Modification> modificationsM;
    @ElementCollection
    private Map<Article,String> avis;

    public int getIdMembre() {
        return idMembre;
    }

    public String getNomMembre() {
        return nomMembre;
    }

    public void setNomMembre(String nomMembre) {
        this.nomMembre = nomMembre;
    }

    public List<Modification> getModificationsM() {
        return modificationsM;
    }

    public void setModificationsM(List<Modification> modificationsM) {
        this.modificationsM = modificationsM;
    }

    public Map<Article, String> getAvis() {
        return avis;
    }

    public void setAvis(Map<Article, String> avis) {
        this.avis = avis;
    }
}
