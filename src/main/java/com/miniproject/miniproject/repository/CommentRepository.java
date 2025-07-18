package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.dto.Response.CommentResponse;
import com.miniproject.miniproject.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comments, String> {
    @Query("SELECT c FROM Comments c WHERE c.post.id = :postId")
    List<Comments> findCommentsByPostId(@Param("postId") String postId);
}
