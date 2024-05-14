package com22.rest1.api;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.categoryDto.CategoryRequest;
import com22.rest1.dto.categoryDto.CategoryResponse;
import com22.rest1.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class CategoryApi {

    private final CategoryService categoryService;

    @GetMapping()
    @Operation(summary = "to get all categories")
    List<CategoryResponse> getAll() {
        return categoryService.getAll();
    }

    @GetMapping("/getById")
    @Operation(summary = "to get category by id")
    CategoryResponse getById(@RequestParam Long categoryId) {
        return categoryService.getById(categoryId);
    }

    @PostMapping
    @Operation(summary = "to create new category")
    SimpleResponse save(@RequestBody CategoryRequest categoryRequest) {
        return categoryService.save(categoryRequest);
    }

    @PutMapping()
    @Operation(summary = "to update a category")
    SimpleResponse update(@RequestParam Long id,
                          @RequestBody CategoryRequest categoryRequest) {
        return categoryService.update(id, categoryRequest);
    }

    @DeleteMapping()
    @Operation(summary = "to delete a category")
    SimpleResponse delete(@RequestParam Long id) {
        return categoryService.delete(id);
    }
}
