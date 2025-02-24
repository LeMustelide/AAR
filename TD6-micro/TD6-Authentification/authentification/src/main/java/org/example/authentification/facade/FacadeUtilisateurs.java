package org.example.authentification.facade;

import org.example.authentification.facade.exceptions.LoginDejaUtiliseException;
import org.example.authentification.facade.exceptions.UtilisateurInexistantException;
import org.example.authentification.modele.Utilisateur;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacadeUtilisateurs {

    private final Map<String, Utilisateur> utilisateursMap;

    public FacadeUtilisateurs() {
        utilisateursMap = new HashMap<>();
    }

    public int getUtilisateurIntId(String email) throws UtilisateurInexistantException {
        return getUtilisateurByEmail(email).getIdUtilisateur();
    }

    public Utilisateur getUtilisateurByEmail(String email) throws UtilisateurInexistantException {
        if (utilisateursMap.containsKey(email))
            return this.utilisateursMap.get(email);
        else
            throw new UtilisateurInexistantException();
    }

    public Utilisateur inscrireUtilisateur(String email, String password) throws LoginDejaUtiliseException {
        if (utilisateursMap.containsKey(email))
            throw new LoginDejaUtiliseException();
        else {
            Utilisateur utilisateur = new Utilisateur(email, password);
            utilisateursMap.put(utilisateur.getEmail(), utilisateur);
            return utilisateur;
        }
    }

    public boolean verifierMotDePasse(String email, String password) {
        if (utilisateursMap.containsKey(email)) {
            return utilisateursMap.get(email).verifierPassword(password);
        } else {
            return false;
        }
    }

    public Collection<Utilisateur> getAllUtilisateurs() {
        return utilisateursMap.values();
    }

}
