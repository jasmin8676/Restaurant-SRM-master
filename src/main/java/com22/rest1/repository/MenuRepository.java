package com22.rest1.repository;

import com22.rest1.dto.menuDto.MenuResponse;
import com22.rest1.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

    @Query("""
            select new com22.rest1.dto.menuDto.MenuResponse(
            m.id,
            m.name,
            m.image,
            m.price,
            m.description,
            m.isVegetarian)
            from Menu m""")
    List<MenuResponse> getAll();




//    m.id,
//    m.name,
//    m.image,
//    m.price,
//    m.description,
//    m.isVegetarian
}