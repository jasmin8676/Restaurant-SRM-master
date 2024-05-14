package com22.rest1.repository;

import com22.rest1.dto.restaurantDto.RestaurantResponse;
import com22.rest1.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("""
            select new com22.rest1.dto.restaurantDto.RestaurantResponse(
            r.id,
            r.name,
            r.location,
            r.numberOfEmployees)
            from Restaurant r
            """)
    List<RestaurantResponse> getAll();

}
