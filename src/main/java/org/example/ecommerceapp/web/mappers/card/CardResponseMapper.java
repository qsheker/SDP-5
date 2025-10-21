package org.example.ecommerceapp.web.mappers.card;

import org.example.ecommerceapp.models.Card;
import org.example.ecommerceapp.web.dto.Card.CardResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardResponseMapper {
    CardResponseDto toDto(Card card);

    Card toEntity(CardResponseDto dto);
}
