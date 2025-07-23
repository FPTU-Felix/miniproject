package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Comments;
import com.miniproject.miniproject.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReactionRepository extends JpaRepository<Reaction, String> {
    @Query("SELECT r FROM Reaction r WHERE r.post.id = :postId")
    List<Reaction> findReactionByPostId(@Param("postId") String postId);
}
