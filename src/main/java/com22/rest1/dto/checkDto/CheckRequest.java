package com22.rest1.dto.checkDto;

import lombok.Builder;
import com22.rest1.entity.Check;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record CheckRequest(
        BigDecimal price,
        LocalDate createdAt
) {

    public Check requestToEntity(){
        return Check.builder()
                .price(this.price)
                .createdAt(this.createdAt)
                .build();
    }

    public Check requestToEntityForUpdate(Check check){
        check.setPrice(this.price);
        check.setCreatedAt(this.createdAt);
        return check;

    }

}
