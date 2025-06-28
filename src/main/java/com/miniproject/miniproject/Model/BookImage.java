package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book_images")
@Getter
@Setter
public class BookImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private int id;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "description")
    private String description;
    @Column(name = "created_at")
    private String createdAt;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("bookImages")
    private Book book;
    public BookImage() {
        // Default constructor
    }
    public BookImage(int id, String imageUrl, String description, String createdAt, Book book) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.description = description;
        this.createdAt = createdAt;
        this.book = book;
    }
}
