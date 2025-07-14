package com.miniproject.miniproject.Repository;

import com.miniproject.miniproject.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
