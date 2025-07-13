package com.miniproject.miniproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "reader")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    @Id
    @Column(name = "reader_id")
    private String id;

    @PrePersist//Auto generate ID if ID doesn't exist
    private void prePersist() {
        if (id == null) {
            id = UUID.randomUUID().toString();
        }
    }

    //Relationship
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("reader")
    private User user;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("reader")
    List<BookOwership> bookOwershipList;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("reader")
    List<Following> followings;

    @OneToMany(mappedBy = "reader", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    List<Rate> rates;

}
