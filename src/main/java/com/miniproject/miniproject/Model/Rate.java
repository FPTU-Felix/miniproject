package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "rate")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rate extends BaseEntity{
    @Id
    @Column(name = "rate_id")
    private String id;

    @Column(name = "score")
    private int score;
//Relationship
    @ManyToOne
    @JoinColumn( name = "reader_id")
    @JsonIgnore
    private Reader reader;

    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("rate")
    private Book book;
    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
