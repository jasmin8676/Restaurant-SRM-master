package com22.rest1.dto.checkDto;

import lombok.Builder;
import com22.rest1.entity.Check;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record CheckResponse(
        Long id,
        BigDecimal price,
        LocalDate createdAt
) {
    public static CheckResponse entityToResponse(Check check){
        return CheckResponse.builder()
                .id(check.getId())
                .price(check.getPrice())
                .createdAt(check.getCreatedAt())
                .build();
    }
}
