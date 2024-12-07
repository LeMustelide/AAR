package services;

import entities.*;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    @Transactional
    public void peuple() {
        em.persist(new AvecAuto());
        em.persist(new AvecSequence());
        em.persist(new AvecTablePremiere());
        em.persist(new AvecTableSeconde());


        em.persist(new ClientAvecCleIDClass("Paul","Scorbut"));
        em.persist(new ClientAvecCleEmbedded("Paul","Scorbut"));

    }

}
