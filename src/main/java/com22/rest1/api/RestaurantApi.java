package com22.rest1.api;

import com22.rest1.dto.SimpleResponse;
import com22.rest1.dto.restaurantDto.RestaurantRequest;
import com22.rest1.dto.restaurantDto.RestaurantResponse;
import com22.rest1.service.RestaurantService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/restaurant")
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping("/getAll")
    @Operation(summary = "to get all restaurant")
    List<RestaurantResponse> getAll(){
        return restaurantService.getAll();
    }

    @GetMapping("/getById")
    @Operation(summary = "to get restaurant by id")
    RestaurantResponse getById(@RequestParam Long id){
        return restaurantService.getById(id);
    }

    @PostMapping
    @Operation(summary = "to create new restaurant")
    SimpleResponse save(@RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.save(restaurantRequest);
    }

    @PutMapping()
    @Operation(summary = "to update the restaurant")
    SimpleResponse update(@RequestParam Long id,
                          @RequestBody RestaurantRequest restaurantRequest){
        return restaurantService.update(id, restaurantRequest);
    }

    @DeleteMapping()
    @Operation(summary = "to delete the restaurant")
    SimpleResponse delete(@RequestParam Long id){
        return restaurantService.delete(id);
    }
}
