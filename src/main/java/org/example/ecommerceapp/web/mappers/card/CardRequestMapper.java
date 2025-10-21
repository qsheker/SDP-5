package org.example.ecommerceapp.web.mappers.card;

import org.example.ecommerceapp.models.Card;
import org.example.ecommerceapp.web.dto.Card.CardRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CardRequestMapper {
    CardRequestDto toDto(Card card);

    Card toEntity(CardRequestDto dto);
}
