package it.exprivia.tutorial.client;

import it.exprivia.tutorial.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "comment-ms", url = "${comment.client.base.url}")
public interface CommentClient {
    @GetMapping("/{commentId}")
   ResponseEntity<Comment> findCommentById(@PathVariable Long commentId);
}
