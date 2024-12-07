package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Avis{

    @Id @ManyToOne
    private Membre membre;

    @Id @ManyToOne
    private Article article;

    private String noteAvis;

    public Avis() {

    }


    public Avis(Membre membre, Article article, String noteAvis) {
        this.membre = membre;
        this.article = article;
        this.noteAvis = noteAvis;
    }

    public Membre getMembre() {
        return membre;
    }


    public Article getArticle() {
        return article;
    }



    public String getNoteAvis() {
        return noteAvis;
    }

    public void setNoteAvis(String noteAvis) {
        this.noteAvis = noteAvis;
    }
}
