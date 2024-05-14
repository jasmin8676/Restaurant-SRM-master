package com22.rest1.repository;

import com22.rest1.dto.categoryDto.CategoryResponse;
import com22.rest1.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select new com22.rest1.dto.categoryDto.CategoryResponse(c.id, c.name) from Category c")
    List<CategoryResponse> getAll();
}
