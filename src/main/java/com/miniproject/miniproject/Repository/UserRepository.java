package com.miniproject.miniproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.miniproject.Model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String userName);//<Prefix>By<FieldName>[And|Or]<FieldName>...
    User findByEmail(String email);
    // Custom query methods can be defined here if needed
    // For example, to find users by username:
    // User findByUsername(String username);
    // Or to find users by email:
    // User findByEmail(String email);
}
