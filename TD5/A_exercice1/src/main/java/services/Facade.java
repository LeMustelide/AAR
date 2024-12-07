package services;

import entities.Employe;
import entities.EmployeDto;
import entities.Telephone;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;


    public Employe getEmploye(int id) {
        return em.find(Employe.class, id);
    }


    public Employe getEmployeFetch(int id) {
        return em.createQuery("SELECT e FROM Employe e Left Join Fetch e.telephones Left join Fetch e.projetsEnCours WHERE e.idEmp = :id", Employe.class).setParameter("id", id).getSingleResult();
    }

//    @Transactional(readOnly = true)
//    public Employe getEmploye2(int id) {
//        Employe e = em.createQuery("SELECT e FROM Employe e WHERE e.idEmp = :id", Employe.class).setParameter("id", id).getSingleResult();
//
//        e.getTelephones().size();
//        e.getProjetsEnCours().size();
//
//        return e;
//    }

    @EntityGraph(attributePaths = {"telephones", "projetsEnCours"})
    public Employe getEmploye3(int id) {
        return em.find(Employe.class, id);
    }

    @Transactional(readOnly = true)
    public EmployeDto getEmployeDTO(int id) {
        Employe e = em.find(Employe.class, id);
        EmployeDto eDto = new EmployeDto(e);
        return eDto;
    }

}
