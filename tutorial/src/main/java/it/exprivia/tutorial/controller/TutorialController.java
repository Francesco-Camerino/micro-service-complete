package it.exprivia.tutorial.controller;

import it.exprivia.tutorial.dto.TutorialCommentDTO;
import it.exprivia.tutorial.model.Tutorial;
import it.exprivia.tutorial.service.ITutorialService;
import it.exprivia.tutorial.service.TutorialServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutorials")
public class TutorialController {

    private static final Logger LOG = LoggerFactory.getLogger(TutorialController.class);
    @Autowired
    private ITutorialService tutorialService;
    @GetMapping
    ResponseEntity<List<Tutorial>> findAllTutorial() {
        LOG.info("findAllTutorial IN");
        return ResponseEntity.ok().body(tutorialService.findAllTutorial());
    }

    @GetMapping("/{tutorialId}")
    ResponseEntity<Tutorial> findTutorialById(@PathVariable Long tutorialId) {
        LOG.info("findTutorialById IN {}",tutorialId);
        return ResponseEntity.ok().body(tutorialService.findById(tutorialId));
    }
    @PostMapping
    ResponseEntity<Tutorial> saveTutorial(@RequestBody Tutorial tutorial) {
        LOG.info("saveTutorial IN {}",tutorial.toString());
        return ResponseEntity.ok().body(tutorialService.saveTutorial(tutorial));
    }

    @GetMapping("/tutorial/with-comment")
    ResponseEntity<TutorialCommentDTO> getTutorialAndCommentByCommentId(@RequestParam Long tutorialId,
                                                                        @RequestParam Long commentId) {
        return ResponseEntity.ok().body(tutorialService.getTutorialAndCommentByCommentId(tutorialId,commentId));
    }
}
