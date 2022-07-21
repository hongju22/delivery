package com.example.delivery1.delivery.validator;

import com.sparta.delivery.dto.RestaurantRequestDto;
import org.springframework.stereotype.Component;

@Component
public class RestaurantValidator {
    public static void validateRestaurantInput(RestaurantRequestDto requestDto){
        int inputMinOrderPrice = requestDto.getMinOrderPrice();
        if(inputMinOrderPrice < 1000 || inputMinOrderPrice > 100000 || (inputMinOrderPrice % 100 != 0)){
            throw new IllegalArgumentException("최소 주문 금액이 유효하지 않습니다.");
        }

        int inputDeliveryFee = requestDto.getDeliveryFee();
        if(inputDeliveryFee < 0 || inputDeliveryFee > 10000 || (inputDeliveryFee % 500 != 0)){
            throw new IllegalArgumentException("배달비가 유효하지 않습니다.");
        }
    }
}
