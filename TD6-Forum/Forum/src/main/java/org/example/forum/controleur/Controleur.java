package org.example.forum.controleur;

import org.example.forum.modele.FacadeApplication;
import org.example.forum.modele.Question;
import org.example.forum.modele.exceptions.AccessIllegalAUneQuestionException;
import org.example.forum.modele.exceptions.QuestionInexistanteException;
import org.example.forum.modele.exceptions.UtilisateurInexistantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class Controleur {

    @Autowired
    private FacadeApplication facadeApplication;

    @PostMapping("/questions")
    public ResponseEntity<Question> ajouterQuestion(@RequestBody String libelleQuestion,
                                                    Authentication authentication,
                                                    UriComponentsBuilder base) {
        int id = Integer.parseInt(authentication.getName());

        Question question = facadeApplication.ajouterUneQuestion(id, libelleQuestion);
        URI location = base.path("/api/utilisateurs/{idUtilisateur}/questions/{idQuestion}")
                .buildAndExpand(id, question.getIdQuestion())
                .toUri();
        return ResponseEntity.created(location).body(question);
    }

    @PatchMapping("/questions/{idQuestion}")
    @PreAuthorize("hasRole('ENSEIGNANT')")
    public ResponseEntity<String> repondreQuestion(@PathVariable String idQuestion,
                                                   @RequestBody String reponse)
            throws QuestionInexistanteException {
        this.facadeApplication.repondreAUneQuestion(idQuestion, reponse);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/questionsByUser")
    public ResponseEntity<Collection<Question>> getSomeQuestionsByUtilisateur(@RequestParam Optional<String> filtre,
                                                                              Authentication authentication) throws UtilisateurInexistantException {
        int id = Integer.parseInt(authentication.getName());
        String f = filtre.orElse("sansFiltre");

        return switch (f) {
            case "sansReponse" -> ResponseEntity.ok(facadeApplication.getQuestionsSansReponsesByUser(id));
            case "avecReponse" -> ResponseEntity.ok(facadeApplication.getQuestionsAvecReponsesByUser(id));
            default -> ResponseEntity.ok(facadeApplication.getToutesLesQuestionsByUser(id));
        };
    }

    @GetMapping("/questions/{idQuestion}")
    @PostAuthorize("hasRole('ENSEIGNANT') or authentication.name == returnObject.body.idUtilisateur")
    public ResponseEntity<Question> getQuestionByUtilisateur(@PathVariable String idQuestion,
                                                             Authentication authentication)
            throws AccessIllegalAUneQuestionException, QuestionInexistanteException, UtilisateurInexistantException {
        int id = Integer.parseInt(authentication.getName());
        Question question = facadeApplication.getQuestionByIdPourUnUtilisateur(id, idQuestion);
        return ResponseEntity.ok(question);

    }

    @GetMapping("/questions")
    @PreAuthorize("hasRole('ENSEIGNANT')")
    public ResponseEntity<Collection<Question>> getQuestion(@RequestParam Optional<String> filtre) {
        String f = filtre.orElse("sansFiltre");
        if ("sansReponse".equals(f)) {
            return ResponseEntity.ok(facadeApplication.getQuestionsSansReponses());
        } else {
            return ResponseEntity.ok(facadeApplication.getToutesLesQuestions());
        }
    }

}