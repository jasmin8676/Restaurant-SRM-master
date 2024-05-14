package com22.rest1.service.impl;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.restaurantDto.RestaurantRequest;
import com22.rest1.dto.restaurantDto.RestaurantResponse;
import com22.rest1.entity.Restaurant;
import com22.rest1.globalException.NotFoundException;
import com22.rest1.repository.RestaurantRepository;
import com22.rest1.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;


    @Override
    public List<RestaurantResponse> getAll() {
        return restaurantRepository.getAll();
    }

    @Override
    public RestaurantResponse getById(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Restaurant not found with id " + id)
        );
        return RestaurantResponse.entityToResponse(restaurant);

    }

    @Override
    public SimpleResponse save(RestaurantRequest restaurantRequest) {
        restaurantRepository.save(restaurantRequest.requestToEntity());
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Restaurant saved")
                .build();
    }

    @Override
    public SimpleResponse update(Long id, RestaurantRequest restaurantRequest) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Restaurant not found with id " + id)
        );
        restaurantRepository.save(restaurantRequest.requestToEntityForUpdate(restaurant));
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Restaurant updated with id " + restaurant.getId())
                .build();
    }

    @Override
    public SimpleResponse delete(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Restaurant not found with id " + id)
        );
        restaurantRepository.deleteById(id);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Restaurant deleted with id " + restaurant.getId())
                .build();
    }
}
