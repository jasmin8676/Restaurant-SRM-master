package com22.rest1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com22.rest1.dto.checkDto.CheckResponse;
import com22.rest1.entity.Check;

import java.util.List;

@Repository
public interface CheckRepository extends JpaRepository<Check, Long> {

    @Query("""
            select new com22.rest1.dto.checkDto.CheckResponse(c.id, c.price, c.createdAt)
            from Check c""")
    List<CheckResponse> getAll();
}