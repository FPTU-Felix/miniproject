package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "chapter")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chapter extends BaseEntity{
    @Id
    @Column(name = "chapter_id")
    private String id;
    @Column(name = "chapter_name")
    private String chapter_name;
    @Column(name = "publish_at")
    private String publish_at;
    @Column(name = "type")
    private String type;
    @Column(name = "next_chapter")
    private String next_chapter;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "chapter-comments")
    private List<Comments> comments;

    @OneToMany(mappedBy = "chapter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "chapter-posts")
    private List<Post> posts;
    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
