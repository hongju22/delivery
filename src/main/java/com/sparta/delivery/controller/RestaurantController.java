package com.example.delivery1.delivery.controller;

import com.sparta.delivery.dto.RestaurantRequestDto;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = restaurantService.getRestaurants();

        return restaurants;
    }

    @PostMapping("/restaurant/register")
    public Restaurant createRestaurant(@RequestBody RestaurantRequestDto requestDto){
        Restaurant restaurant = restaurantService.createRestaurant(requestDto);
        return restaurant;
    }

    @DeleteMapping("/restaurant/{restaurantId}")
    public Long deleteRestaurant(@PathVariable Long restaurantId){
        Long deletedId = restaurantService.deleteRestaurant(restaurantId);
        return deletedId;
    }

}