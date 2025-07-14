package com.miniproject.miniproject.Repository;

import com.miniproject.miniproject.Model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comments, String> {
}
