package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "post_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostImage extends BaseEntity{
    @Id
    @Column(name = "postImg_id")
    private String id;

    @Column(name = "img_url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnoreProperties("postImages")
    private Post post;
    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist(){
        if(id==null){
            id = UUID.randomUUID().toString();
        }
    }
}
