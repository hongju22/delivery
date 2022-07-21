package com.example.delivery1.delivery.validator;

import com.sparta.delivery.dto.FoodRequestDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FoodValidator {
    public static void validateFoodInput(List<FoodRequestDto> requestDtoList){
        for(FoodRequestDto eachFood : requestDtoList){
            int inputPrice = eachFood.getPrice();

            if(inputPrice < 100 || inputPrice > 1000000 || (inputPrice % 100 != 0)){
                throw new IllegalArgumentException("입력한 음식 가격이 유효하지 않습니다.");
            }
        }

        for(int i=0; i<requestDtoList.size(); i++){
            for(int j=0; j<i; j++){
                if(requestDtoList.get(i).getName().equals(requestDtoList.get(j).getName())){
                    throw new IllegalArgumentException("음식을 중복되게 입력할 수 없습니다.");
                }
            }
        }
    }
}
