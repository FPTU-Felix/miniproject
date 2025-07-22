package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.ReactionResponse;
import com.miniproject.miniproject.model.Reaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReactionMapper {
    ReactionResponse toDTO(Reaction reaction);
}
