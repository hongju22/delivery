package com.example.delivery1.delivery.repository;

import com.sparta.delivery.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
