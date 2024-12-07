package org.example.forum.dao;

import org.example.forum.modele.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findByLibelleQuestion(String titre);

}
