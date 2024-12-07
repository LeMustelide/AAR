package org.example.authentification;

import org.example.authentification.dao.UtilisateurRepository;
import org.example.authentification.modele.Utilisateur;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AuthentificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthentificationApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(UtilisateurRepository utilisateurRepository) {
        return args -> {
            utilisateurRepository.save(new Utilisateur("admin", "admin"));
        };
    }
}
