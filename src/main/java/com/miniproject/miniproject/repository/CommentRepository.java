package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, String> {
}
