package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.internal.GenerationStrategyInterpreter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "comment")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private String createdAt;

    //Relationships with User and Post can be added here if needed
    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("comments")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chapter_id")
    @JsonIgnoreProperties("comments")
    private Chapter chapter;

    @OneToOne(mappedBy = "comments")
    @JsonIgnoreProperties("comments")
    private Reaction reaction;

    @ManyToOne
    @JoinColumn(name = "replied_to_id") // Foreign key column
    @JsonIgnoreProperties("replies")
    private Comments repliedTo;

    @OneToMany(mappedBy = "repliedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("repliedTo")
    private List<Comments> replies;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }//
}
