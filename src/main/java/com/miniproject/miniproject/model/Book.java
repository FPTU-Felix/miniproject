package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Book extends BaseEntity {
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

    // Relationship
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-favorites")
    private List<Favorite> favorites;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-bookOwnerShip")
    private List<BookOwership> bookOwershipList;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-rates")
    private List<Rate> rate;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-bookCategory")
    private List<BookCategory> bookCategories;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference(value = "book-posts")
    private List<Post> posts;

    @ManyToOne
    @JoinColumn(name = "published_by")
    @JsonBackReference(value = "book-publishers")
    private Publisher publisher;
}
