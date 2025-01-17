package org.example.authentification.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Utilisateur {

    private static int lastId = 0;

    private String email;
    private String password;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUtilisateur;


    public Utilisateur(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Utilisateur() {

    }

    public String getEncodedPassword() {
        return password;
    }

    public boolean verifierPassword(String motDePasse) {
        return this.password.equals(motDePasse);
    }

}
