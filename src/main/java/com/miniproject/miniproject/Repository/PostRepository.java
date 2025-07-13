package com.miniproject.miniproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.miniproject.Model.Post;

public interface PostRepository extends JpaRepository<Post, String> {

    // Custom query methods can be defined here if needed
    // For example, to find posts by title:
    // List<Post> findByTitleContaining(String title);
    // Or to find posts by user:
    // List<Post> findByUserId(Integer userId);
}
