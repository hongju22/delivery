package com.example.delivery1.delivery.service;

import com.sparta.delivery.dto.FoodRequestDto;
import com.sparta.delivery.model.Food;
import com.sparta.delivery.model.Restaurant;
import com.sparta.delivery.repository.FoodRepository;
import com.sparta.delivery.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class FoodService {
    private FoodRepository foodRepository;
    private RestaurantRepository restaurantRepository; //이거 흠 효율적?

    @Autowired
    public FoodService(FoodRepository foodRepository, RestaurantRepository restaurantRepository){
        this.foodRepository = foodRepository;
        this.restaurantRepository =restaurantRepository;
    }

    @Transactional
    public List<Food> createFoods(List<FoodRequestDto> requestDtoList, Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElse(null);

        List<String> existingFoodName = new ArrayList<>();
        List<Food> existingFoodList = foodRepository.findAllByRestaurant(restaurant);
        for(Food eachExistingFood : existingFoodList){
            String name = eachExistingFood.getName();
            existingFoodName.add(name);
        }

        for(FoodRequestDto eachCompare : requestDtoList){
            //넣으려는 음식 리스트
            String inputName = eachCompare.getName();
            for(String eachName : existingFoodName){
                if(inputName.equals(eachName)) {
                    throw new IllegalArgumentException("이미 등록된 음식이 존재합니다.");
                }
            }
        }


        List<Food> createdFoodList = new ArrayList<>();
        for(FoodRequestDto eachFood : requestDtoList) {
            String name = eachFood.getName();
            int price = eachFood.getPrice();
            Food food = new Food(name, price, restaurant);
            foodRepository.save(food);
            createdFoodList.add(food);
        }
        return createdFoodList;
    }

    public List<Food> getFoods(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(
                        ()-> new NullPointerException("해당 레스토랑이 없습니다."));
        return foodRepository.findAllByRestaurant(restaurant);
    }
}
