package com22.rest1.dto.categoryDto;

import com22.rest1.entity.Category;
import lombok.Builder;


@Builder
public record CategoryResponse(
        Long id,
        String name

) {
    public Category build() {
        return new Category(this.name);
    }
}
