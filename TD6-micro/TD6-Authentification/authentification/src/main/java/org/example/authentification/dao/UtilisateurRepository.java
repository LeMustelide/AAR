package org.example.authentification.dao;

import org.example.authentification.modele.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByEmail(String email);
}
