package it.exprivia.tutorial.dto;

import it.exprivia.tutorial.model.Comment;

public class TutorialCommentDTO {
    private Long id;

    private String title;

    private Comment comment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
