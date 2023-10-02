package it.exprivia.tutorial.service;

import it.exprivia.tutorial.dto.TutorialCommentDTO;
import it.exprivia.tutorial.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ITutorialService {
    List<Tutorial> findAllTutorial();
    Tutorial findById(Long tutorialId);

    Tutorial saveTutorial(Tutorial tutorial);
    TutorialCommentDTO getTutorialAndCommentByCommentId(Long tutorialID, Long commentId);
}
