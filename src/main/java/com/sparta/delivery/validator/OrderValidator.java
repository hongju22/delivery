package com.example.delivery1.delivery.validator;

import com.sparta.delivery.dto.OrderItemRequestDto;
import com.sparta.delivery.dto.OrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {
    public static void validateOrderInput(OrderRequestDto requestDto) {
        for(OrderItemRequestDto eachItem : requestDto.getFoods()){
            if(eachItem.getQuantity() < 1 || eachItem.getQuantity() > 100){
                throw new IllegalArgumentException("주문량이 허용 범위를 초과했습니다.");
            }
        }
    }

    public static void validateOrderPrice(int minOrderPrice, int totalPrice){
        if(minOrderPrice > totalPrice){
            throw new IllegalArgumentException("최소 주문 금액을 맞춰주세요!");
        }
    }
}