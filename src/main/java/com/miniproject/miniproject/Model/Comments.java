package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.boot.internal.GenerationStrategyInterpreter;

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
    @JsonIgnoreProperties("comments")
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

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }//
}
