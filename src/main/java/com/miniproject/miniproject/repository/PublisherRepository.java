package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
