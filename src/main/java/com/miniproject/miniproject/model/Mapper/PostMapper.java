package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.PostResponse;
import com.miniproject.miniproject.model.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostResponse toDTO(Post post);
}
