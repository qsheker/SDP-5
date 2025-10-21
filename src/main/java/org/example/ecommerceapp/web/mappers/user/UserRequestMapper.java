package org.example.ecommerceapp.web.mappers.user;

import org.example.ecommerceapp.models.User;
import org.example.ecommerceapp.web.dto.user.UserRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRequestMapper {
    UserRequestDto toDto(User user);

    User toEntity(UserRequestDto dto);
}
