package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, String> {
}
