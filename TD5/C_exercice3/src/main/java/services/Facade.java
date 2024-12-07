package services;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;




}
