package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "book_ownership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookOwership {
    @Id
    @Column(name = "bookownership_id")
    private String id;

    @Column(name = "created_at")
    private String createdAt;
    //Relationship
    @ManyToOne
    @JoinColumn(name = "reader_id")
    @JsonIgnoreProperties("book_ownership")
    private Reader reader;

    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("book_ownership")
    private Book book;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
