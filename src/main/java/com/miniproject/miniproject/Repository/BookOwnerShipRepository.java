package com.miniproject.miniproject.Repository;

import com.miniproject.miniproject.Model.BookOwership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookOwnerShipRepository extends JpaRepository<BookOwership, String> {
}
