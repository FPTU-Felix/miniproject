package com.miniproject.miniproject.Speicification;

import com.miniproject.miniproject.dto.Request.BookFilterRequest;
import com.miniproject.miniproject.model.Book;
import com.miniproject.miniproject.model.BookCategory;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class BookSpecification {
    public static Specification<Book> getBooks(BookFilterRequest request) {
        return (Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();
            if (request.getId() != null && !request.getId().isBlank()) {
                predicate = cb.equal(root.get("id"), UUID.fromString(request.getId()));
                return predicate;
            }
            if (request.getTitle() != null && !request.getTitle().isBlank()) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("name")), "%" + request.getTitle().toLowerCase() + "%"));
            }

            if (request.getPublisher() != null && !request.getPublisher().isBlank()) {
                predicate = cb.and(predicate, cb.equal(root.get("publisher").get("id"), UUID.fromString(request.getPublisher())));
            }

            if (request.getCategory() != null && !request.getCategory().isBlank()) {
                List<String> categories = Arrays.stream(request.getCategory().split(",")).map(String::trim).toList();
                Join<Book, BookCategory> bookBookCategoryJoin = root.join("bookCategories", JoinType.INNER);
                predicate = cb.and(predicate, bookBookCategoryJoin.get("category").in(categories));
            }

            return predicate;
        };
    }
}
