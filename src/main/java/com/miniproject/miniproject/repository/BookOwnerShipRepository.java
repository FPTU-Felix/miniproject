package com.miniproject.miniproject.repository;

import com.miniproject.miniproject.model.BookOwership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOwnerShipRepository extends JpaRepository<BookOwership, String> {
}
