package it.exprivia.comment.service;

import it.exprivia.comment.model.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> findAllComment();
    Comment findById(Long commentId);

    Comment saveComment(Comment comment);
}
