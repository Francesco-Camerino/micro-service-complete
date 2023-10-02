package it.exprivia.tutorial.service;

import it.exprivia.tutorial.client.CommentClient;
import it.exprivia.tutorial.dto.TutorialCommentDTO;
import it.exprivia.tutorial.model.Comment;
import it.exprivia.tutorial.model.Tutorial;
import it.exprivia.tutorial.repository.TutorialRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TutorialServiceImpl implements ITutorialService{

    private static final Logger LOG = LoggerFactory.getLogger(TutorialServiceImpl.class);
    @Autowired
    private TutorialRepository tutorialRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CommentClient commentClient;

    public TutorialServiceImpl() {
    }

    @Override
    public List<Tutorial> findAllTutorial() {
        LOG.info("service: findAllTutorial IN");
        return tutorialRepository.findAll();
    }

    @Override
    public Tutorial findById(Long tutorialId) {
        LOG.info("service: findById IN");
        return tutorialRepository.findById(tutorialId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutorial not found with id = " + tutorialId) );
    }

    @Override
    public Tutorial saveTutorial(Tutorial tutorial) {
        LOG.info("service: saveTutorial IN");
        return tutorialRepository.save(tutorial);
    }

    @Override
    public TutorialCommentDTO getTutorialAndCommentByCommentId(Long tutorialId, Long commentId) {
        LOG.info("service: getTutorialAndCommentByCommentId IN");
        Tutorial tutorial = findById(tutorialId);
        TutorialCommentDTO tutorialCommentDTO = modelMapper.map(tutorial, TutorialCommentDTO.class);

        Comment comment = commentClient.findCommentById(commentId).getBody();

        tutorialCommentDTO.setComment(comment);
        return tutorialCommentDTO;
    }
}
