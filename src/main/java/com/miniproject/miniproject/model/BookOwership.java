package com.miniproject.miniproject.model;

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

//    @Column(name = "created_at")
//    private String createdAt;
    //Relationship
    @ManyToOne
    @JoinColumn(name = "reader_id")
    @JsonIgnoreProperties("bookOwershipList")
    private Reader reader;

    @OneToOne
    @JoinColumn(name = "book_id")
    @JsonIgnoreProperties("bookOwershipList")
    private Book book;
}
