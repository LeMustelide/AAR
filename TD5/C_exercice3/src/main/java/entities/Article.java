package entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Article {
    @Id
    @GeneratedValue
    private int idArticle;
    private String titreArticle;
    @Column(length = 1024)
    private String texteArticle;
    @OneToMany(mappedBy = "articleM")
    private List<Modification> modificationsA;
    @ElementCollection
    private List<String> motscles;

    public int getIdArticle() {
        return idArticle;
    }

    public String getTitreArticle() {
        return titreArticle;
    }

    public void setTitreArticle(String titreArticle) {
        this.titreArticle = titreArticle;
    }

    public String getTexteArticle() {
        return texteArticle;
    }

    public void setTexteArticle(String texteArticle) {
        this.texteArticle = texteArticle;
    }

    public List<Modification> getModificationsA() {
        return modificationsA;
    }

    public void setModificationsA(List<Modification> modificationsA) {
        this.modificationsA = modificationsA;
    }

    public List<String> getMotscles() {
        return motscles;
    }

    public void setMotscles(List<String> motscles) {
        this.motscles = motscles;
    }
}
