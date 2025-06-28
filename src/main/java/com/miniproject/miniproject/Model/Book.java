package com.miniproject.miniproject.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "authors")
    private String author;

    @Column(name = "publisher")
    private String publisher;

    @Column(name = "page_count")// note lai ve syntax mysql voi hibernate
    private int pageCount;

    @Column(name = "print_type")
    private String printType;

    @Column(name = "language")
    private String language;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "created_at")
    private String dateCreated;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("book")
    private List<BookImage> bookImages;

    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    @JsonIgnoreProperties("books")
    private List<Category> categories;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<Borrowings> borrowings;

    public Book() {
        // Default constructor
    }

    public Book(int id, String code, String title, String author, String publisher, int pageCount, String printType,
                String language, String description, int quantity, String dateCreated, List<BookImage> bookImages, List<Category> categories, List<Borrowings> borrowings) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
        this.printType = printType;
        this.language = language;
        this.description = description;
        this.quantity = quantity;
        this.dateCreated = dateCreated;
        this.bookImages = bookImages;
        this.categories = categories;
        this.borrowings = borrowings;
    }
}
