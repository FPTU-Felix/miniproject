package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "book_category")
public class BookCategory {
    @Id
    @Column(name = "bookcategory_id")
    private String id;
    //Relationship
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("book_category")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnoreProperties("book_category")
    private Category category;

}
