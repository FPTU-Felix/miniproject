package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "reaction")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Reaction extends BaseEntity{
    @Id
    @Column(name = "reaction_id")
    private String reaction_id;

    @Column(name = "type")
    private String type;
    //Relationship
    @ManyToOne
    @JoinColumn(name = "user_id")//Foreign Key
    @JsonBackReference(value = "user-reactions")
    private User user;

    @OneToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference(value = "post-reaction")
    private Post post;

    @OneToOne
    @JoinColumn(name = "comment_id")
    @JsonBackReference(value = "comment-reaction")
    private Comments comments;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(reaction_id==null){
            reaction_id = UUID.randomUUID().toString();
        }
    }
}
