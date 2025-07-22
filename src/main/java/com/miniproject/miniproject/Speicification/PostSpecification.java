package com.miniproject.miniproject.Speicification;

import com.miniproject.miniproject.dto.Request.PostFilterRequest;
import com.miniproject.miniproject.model.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class PostSpecification {
    public static Specification<Post> getPost(PostFilterRequest request) {
        return (Root<Post> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Predicate predicate = cb.conjunction();
            if (request.getId() != null && !request.getId().isBlank()) {
                predicate = cb.equal(root.get("id"), UUID.fromString(request.getId()));
                return predicate;
            }
            if (request.getTitle() != null && !request.getTitle().isBlank()) {
                predicate = cb.and(predicate, cb.like(cb.lower(root.get("title")), "%" + request.getTitle().toLowerCase() + "%"));
            }
//            if (request.getBook() != null && !request.getBook().isBlank()) {
//                predicate = cb.and(predicate, cb.like(cb.lower(root.get())));
//            }
            return predicate;
        };
    }
}
