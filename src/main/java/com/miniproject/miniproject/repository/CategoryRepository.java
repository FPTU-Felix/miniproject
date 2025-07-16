package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
