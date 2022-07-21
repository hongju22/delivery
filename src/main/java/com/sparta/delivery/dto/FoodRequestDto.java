package com.example.delivery1.delivery.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FoodRequestDto {

    private final String name;
    private final int price;

}