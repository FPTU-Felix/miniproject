package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.BookResponse;
import com.miniproject.miniproject.dto.Response.CategoryResponse;
import com.miniproject.miniproject.model.Book;
import com.miniproject.miniproject.model.Rate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PublisherMapper.class})
public interface BookMapper {
    @Mapping(target = "categories", expression = "java(getCategories(book))")
    @Mapping(target = "rate", expression = "java(getAverageRating(book))")
    BookResponse toDTO(Book book);

    default double getAverageRating(Book b) {
        try {
            if (b.getRate().isEmpty()) {
                return 0.0;
            }
            return b.getRate().stream().mapToDouble(Rate::getScore).average().orElse(0.0);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    default List<CategoryResponse> getCategories(Book b) {
        try {
            return b.getBookCategories().stream().map(bc -> new CategoryResponse(bc.getCategory().getId(), bc.getCategory().getName())).toList();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
