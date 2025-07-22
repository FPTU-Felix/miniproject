package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookCategory extends BaseEntity{
    @Id
    @Column(name = "bookcategory_id")
    private String id;
    //Relationship
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-bookCategory")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference(value = "category-bookCategory")
    private Category category;

}
