package com.miniproject.miniproject.model.Mapper;

import com.miniproject.miniproject.dto.Response.UserDTO;
import com.miniproject.miniproject.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);
}
