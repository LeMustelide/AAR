package services;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

//    @Transactional
//    public void createEtudiant(String numEtu, String prenom, String nom) {
//        Etudiant etu = new Etudiant(numEtu, prenom, nom);
//        em.persist(etu);
//    }
//
//    public Collection<Etudiant> findAllEtudiant() {
//        return em.createQuery("From Etudiant e").getResultList();
//    }
}
