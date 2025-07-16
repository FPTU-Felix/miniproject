package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Following;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowingRepository extends JpaRepository<Following, String> {
}
