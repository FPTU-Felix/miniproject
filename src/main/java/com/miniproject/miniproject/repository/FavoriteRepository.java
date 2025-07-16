package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, String> {
}
