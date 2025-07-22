package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.CategoryResponse;
import com.miniproject.miniproject.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryResponse toDTO(Category category);
}
