package com22.rest1.service.impl;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.categoryDto.CategoryRequest;
import com22.rest1.dto.categoryDto.CategoryResponse;
import com22.rest1.entity.Category;
import com22.rest1.globalException.NotFoundException;
import com22.rest1.repository.CategoryRepository;
import com22.rest1.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;


    // pagination only get all method
    @Override
    public List<CategoryResponse> getAll() {
        return categoryRepository.getAll();
    }

    @Override
    public CategoryResponse getById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new NotFoundException(
                        "There is no category with id: " + id
                )
        );
        return new CategoryResponse(
                category.getId(),
                category.getName()
        );
    }

    @Override
    public SimpleResponse save(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.name());
        categoryRepository.save(category);
        return new SimpleResponse(
                HttpStatus.OK,
                "Category saved with id: " + category.getId()
        );
    }

    @Override
    public SimpleResponse update(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()  -> new NotFoundException("Category not found with id " + id)
        );
        category.setName(categoryRequest.name());
        categoryRepository.save(category);
        return new SimpleResponse(
                HttpStatus.OK,
                "Category updated with id " + id
        );
    }

    @Override
    public SimpleResponse delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()  -> new NotFoundException("Category not found with id " + id)
        );
        categoryRepository.delete(category);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Category deleted with id " + id)
                .build();
    }
}
