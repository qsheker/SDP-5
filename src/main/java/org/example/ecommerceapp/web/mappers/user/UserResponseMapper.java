package org.example.ecommerceapp.web.mappers.user;

import org.example.ecommerceapp.models.User;
import org.example.ecommerceapp.web.dto.user.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponseDto toDto(User user);

    User toEntity(UserResponseDto dto);
}
