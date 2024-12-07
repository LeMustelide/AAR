package entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Modification {
    @Id @GeneratedValue
    private int idModif;
    @Basic
    private LocalDate dateModif;
    @ManyToOne
    private Membre modificateur;
    @ManyToOne
    private Article articleM;

    public int getIdModif() {
        return idModif;
    }

    public LocalDate getDateModif() {
        return dateModif;
    }

    public void setDateModif(LocalDate dateModif) {
        this.dateModif = dateModif;
    }

    public Membre getModificateur() {
        return modificateur;
    }

    public void setModificateur(Membre modificateur) {
        this.modificateur = modificateur;
    }

    public Article getArticleM() {
        return articleM;
    }

    public void setArticleM(Article articleM) {
        this.articleM = articleM;
    }
}
