package it.exprivia.comment.controller;

import it.exprivia.comment.model.Comment;
import it.exprivia.comment.service.ICommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private ICommentService commentService;

    @GetMapping
    ResponseEntity<List<Comment>> findAllComment() {
        LOG.info("findAllComment IN");
        return ResponseEntity.ok().body(commentService.findAllComment());
    }

    @GetMapping("/{commentId}")
    ResponseEntity<Comment> findCommentById(@PathVariable Long commentId) {
        LOG.info("findCommentById IN {}",commentId);
        return ResponseEntity.ok().body(commentService.findById(commentId));
    }
    @PostMapping
    ResponseEntity<Comment> saveComment(@RequestBody Comment comment) {
        LOG.info("saveComment IN {}",comment.toString());
        return ResponseEntity.ok().body(commentService.saveComment(comment));
    }
}
