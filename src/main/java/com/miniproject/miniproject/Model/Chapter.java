package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chapter")
public class Chapter {
    @Id
    @Column(name = "chapter_id")
    private String id;
    @Column(name = "chapter_name")
    private String name;
    @Column(name = "created_at")
    private String created_at;
    @Column(name = "publish_at")
    private String publish_at;
    @Column(name = "type")
    private String type;
    @Column(name = "next_chapter")
    private String next_chapter;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("chapter")
    private List<Comments> comments;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("chapter")
    private List<Post> posts;
    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
