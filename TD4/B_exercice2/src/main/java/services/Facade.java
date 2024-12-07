package services;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

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
