package com.miniproject.miniproject.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "img")
    private String img;

    @Column(name = "age")
    private int age;

    @Column(name = "address")
    private String address;

    @Column(name = "created_at")
    private String createdAt;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Borrowings> borrowings;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Comments> comments;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties("user")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    @JsonIgnoreProperties("users")
    private List<Role> roles;

    // Default constructor
    public User() {
        // Default constructor
    }

    public User(int id, String username, String password, String fullName, String phoneNumber, String email, String img, int age, String address, String createdAt, List<Borrowings> borrowings, List<Comments> comments, List<Post> posts, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.img = img;
        this.age = age;
        this.address = address;
        this.createdAt = createdAt;
        this.borrowings = borrowings;
        this.comments = comments;
        this.posts = posts;
        this.roles = roles;
    }

}
