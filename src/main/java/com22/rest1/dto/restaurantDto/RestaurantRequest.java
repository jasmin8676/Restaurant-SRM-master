package com22.rest1.dto.restaurantDto;

import com22.rest1.entity.Restaurant;

public record RestaurantRequest(
        String name,
        String location,
        int numberOfEmployees
) {
    public Restaurant requestToEntity(){
        return Restaurant.builder()
                .name(this.name)
                .location(this.location)
                .numberOfEmployees(this.numberOfEmployees)
                .build();
    }

    public Restaurant requestToEntityForUpdate(Restaurant restaurant){
        restaurant.setName(this.name);
        restaurant.setLocation(this.location);
        restaurant.setNumberOfEmployees(this.numberOfEmployees);
        return restaurant;
    }
}
