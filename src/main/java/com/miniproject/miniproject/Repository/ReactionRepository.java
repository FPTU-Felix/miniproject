package com.miniproject.miniproject.Repository;

import com.miniproject.miniproject.Model.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, String> {
}
