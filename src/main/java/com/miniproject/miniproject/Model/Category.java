package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity{
    @Id
    @Column(name = "category_id")
    private String id;
    @Column(name = "cayegory_name")
    private String name;

    @OneToMany
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("category")
    private List<BookCategory> bookCategories;
    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
