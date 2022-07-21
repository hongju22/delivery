package com.example.delivery1.delivery.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor

public class OrderRequestDto {
    private final Long restaurantId;
    private final List<OrderItemRequestDto> foods;
}