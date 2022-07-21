package com.example.delivery1.delivery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class OrderResponseFoodsDto {
    private String name;
    private int quantity;
    private int price;

    public OrderResponseFoodsDto(String name, int quantity, int price) {
        this.name = name;
        this.quantity = quantity;
        this.price= price;
    }
}
