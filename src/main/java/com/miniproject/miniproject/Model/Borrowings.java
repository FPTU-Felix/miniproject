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
@Table(name = "borrowings")
@Getter
@Setter
public class Borrowings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private int id;
    @Column(name = "borrow_date")
    private String borrowDate;
    @Column(name = "return_date")
    private String returnDate;
    @Column(name = "returned")
    private String status;
    //Relationships
    @ManyToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("borrowings")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("borrowings")
    private User user;

    public Borrowings() {
        // Default constructor
    }

    public Borrowings(int id, String borrowDate, String returnDate, String status, Book book, User user) {
        this.id = id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.status = status;
        this.book = book;
        this.user = user;
    }
}
