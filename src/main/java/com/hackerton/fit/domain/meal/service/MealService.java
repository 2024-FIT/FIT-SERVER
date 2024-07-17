package com.hackerton.fit.domain.meal.service;

import com.hackerton.fit.domain.meal.client.MealClient;
import com.hackerton.fit.domain.meal.dto.FoodDataDto;
import com.hackerton.fit.domain.meal.entity.FoodDataEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MealService {
    private final MealClient mealClient;

    public List<FoodDataDto> getData(String foodName) {
         FoodDataEntity foodData = mealClient.getData(foodName);
        return foodData.getFoodData().getRow().stream()
                .map(FoodDataDto::of)
//                 .map(FoodDataDto::of)
                 .toList();
    }
}