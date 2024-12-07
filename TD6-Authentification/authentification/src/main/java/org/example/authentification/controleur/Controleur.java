package org.example.authentification.controleur;

import org.example.authentification.facade.FacadeUtilisateurs;
import org.example.authentification.modele.Utilisateur;
import org.example.authentification.facade.exceptions.LoginDejaUtiliseException;
import org.example.authentification.facade.exceptions.UtilisateurInexistantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.function.Function;

@RestController
@RequestMapping("/api")
public class Controleur {

    @Autowired
    private FacadeUtilisateurs facadeUtilisateurs;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private Function<Utilisateur,String> genereToken;

    public record LoginDTO(String email, String password) {
    }


    @PostMapping("/utilisateurs")
    public ResponseEntity<Utilisateur> inscrire(@RequestBody LoginDTO loginDTO,
                                                UriComponentsBuilder base)
    {
        Utilisateur utilisateur;
        try {
            utilisateur = facadeUtilisateurs.inscrireUtilisateur(loginDTO.email, passwordEncoder.encode(loginDTO.password));
        } catch (LoginDejaUtiliseException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        URI location = base.path("/api/utilisateurs/{idUtilisateur}")
                .buildAndExpand(utilisateur.getIdUtilisateur())
                .toUri();
        return ResponseEntity.created(location).header("Authorization","Bearer "+genereToken.apply(utilisateur)).body(utilisateur);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        try {
            Utilisateur utilisateur = facadeUtilisateurs.getUtilisateurByEmail(loginDTO.email());
            if (passwordEncoder.matches(loginDTO.password(), utilisateur.getEncodedPassword())) {
                return ResponseEntity.status(HttpStatus.OK).header("Authorization","Bearer "+genereToken.apply(utilisateur)).build();
            }
            else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (UtilisateurInexistantException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}