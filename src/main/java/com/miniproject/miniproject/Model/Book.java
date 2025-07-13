package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book {
    @Id
    @Column(name = "book_id")
    private String id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "cover_image")
    private String coverImg;

    @Column(name = "price")
    private Double price;

    @Column(name = "publish_date")
    private String publishDate;

    @Column(name = "created_at")
    private String createdAt;

    @Column(name = "last_update")
    private String lastUpdate;
    // Relationship
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private List<BookOwership> bookOwershipList;

    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private Rate rate;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private List<BookCategory> bookCategories;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Post> posts;

    @OneToOne
    @JoinColumn(name = "published_by")
    private Publisher publisher;
}
