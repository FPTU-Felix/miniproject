package com.miniproject.miniproject.Model;

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
    @JsonIgnoreProperties("following")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    @JsonIgnoreProperties("following")
    private Publisher publisher;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
