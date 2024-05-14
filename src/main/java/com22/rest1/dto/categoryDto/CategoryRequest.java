package com22.rest1.dto.categoryDto;

import lombok.Builder;

@Builder
public record CategoryRequest(
        String name
) {
}
