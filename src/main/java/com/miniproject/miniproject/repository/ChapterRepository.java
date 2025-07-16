package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, String> {
}
