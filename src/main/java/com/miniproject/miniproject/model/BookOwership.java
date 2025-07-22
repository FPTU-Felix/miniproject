package com.miniproject.miniproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book_ownership")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookOwership extends BaseEntity{
    @Id
    @Column(name = "bookownership_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    //Relationship
    @ManyToOne
    @JoinColumn(name = "reader_id")
    @JsonBackReference(value = "reader-bookOwnerShip")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonBackReference(value = "book-bookOwnerShip")
    private Book book;
}
