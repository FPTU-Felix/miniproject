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
@Table(name = "following")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Following extends BaseEntity{
    @Id
    @Column(name = "following_id")
    private String id;
    //Relationship

    @ManyToOne
    @JoinColumn(name = "reader_id")
    @JsonBackReference(value = "reader-followings")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonBackReference(value = "publisher-followings")
    private Publisher publisher;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
