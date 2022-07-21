package com.example.delivery1.delivery.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor

public class RestaurantRequestDto {
    private final String name;
    private final int minOrderPrice;
    private final int deliveryFee;

}