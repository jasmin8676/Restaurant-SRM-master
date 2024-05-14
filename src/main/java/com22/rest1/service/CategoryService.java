package com22.rest1.service;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.categoryDto.CategoryRequest;
import com22.rest1.dto.categoryDto.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAll();

    CategoryResponse getById(Long id);

    SimpleResponse save(CategoryRequest categoryRequest);

    SimpleResponse update(Long id, CategoryRequest categoryRequest);

    SimpleResponse delete(Long id);
}
