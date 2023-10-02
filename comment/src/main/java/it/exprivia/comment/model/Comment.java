package it.exprivia.comment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Comment {
    @Id
    @SequenceGenerator(name = "comment_id_seq_gen" ,sequenceName = "comment_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq_gen")
    @Schema(hidden = true)
    private Long id;

    private String content;

    private Long replies;

    private Long likes;

    private Boolean hearthed;

    public Comment() {
    }

    public Comment(String content, Long replies, Long likes, Boolean hearthed) {
        this.content = content;
        this.replies = replies;
        this.likes = likes;
        this.hearthed = hearthed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getReplies() {
        return replies;
    }

    public void setReplies(Long replies) {
        this.replies = replies;
    }

    public Long getLikes() {
        return likes;
    }

    public void setLikes(Long likes) {
        this.likes = likes;
    }

    public Boolean getHearthed() {
        return hearthed;
    }

    public void setHearthed(Boolean hearthed) {
        this.hearthed = hearthed;
    }
}
