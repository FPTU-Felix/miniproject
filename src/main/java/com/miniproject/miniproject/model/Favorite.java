package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "favorite")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Favorite extends BaseEntity{
    @Id
    @Column(name = "favorite_id")
    private String id;
    //Relationship
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-favorites")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-favorites")
    private Book book;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
