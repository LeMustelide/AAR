package services;

import entities.Article;
import entities.Avis;
import entities.Membre;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

@Transactional
    public void peupler(){
        Article a=new Article();
        a.setTexteArticle("zoubidou");
        a.setTitreArticle("maisquoi");
        em.persist(a);

        Membre m=new Membre();
        m.setNomMembre("znorg");
        em.persist(m);

        Avis avis=new Avis(m,a,"bof");
        em.persist(avis);

    }


}
