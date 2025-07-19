package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.PublisherResponse;
import com.miniproject.miniproject.model.Publisher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface PublisherMapper {

    PublisherResponse toDTO(Publisher publisher);
}
