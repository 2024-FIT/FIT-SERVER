package com.hackerton.fit.domain.meal.service;

import com.hackerton.fit.domain.meal.dto.NutritionDataDTO;
import com.hackerton.fit.domain.meal.dto.FoodDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SearchService {

    private final RestTemplate restTemplate;
    private final String apiUrl = "http://openapi.foodsafetykorea.go.kr/api/sample/I2790/json/1/5/DESC_KOR=";

    public List<NutritionDataDTO> fetchAndTransformData(String food) {
        FoodDataResponse foodDataResponse = restTemplate.getForObject(apiUrl + food, FoodDataResponse.class);
        if (foodDataResponse != null) {
            FoodDataResponse.FoodData foodData = foodDataResponse.getFoodData();
            if (foodData.getRow() == null) { //공공데이터 버그
                foodDataResponse = restTemplate.getForObject(apiUrl + food, FoodDataResponse.class);
                if (foodDataResponse != null) {
                    foodData = foodDataResponse.getFoodData();
                    return transformData(foodData);
                }
                return List.of();
            }
            return transformData(foodData);
        }
        return List.of();
    }

    private List<NutritionDataDTO> transformData(FoodDataResponse.FoodData foodData) {

        if (foodData.getRow() == null) {
            return Collections.emptyList();
        }

        return foodData.getRow().stream().map(data -> {
            NutritionDataDTO dto = new NutritionDataDTO();
            dto.setDescKor(data.getDescKor());
            dto.setCalorie(data.getNutrCont1().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont1()));
            dto.setCarbohydrate(data.getNutrCont2().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont2()));
            dto.setProtein(data.getNutrCont3().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont3()));
            dto.setProvince(data.getNutrCont4().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont4()));
            dto.setSugar(data.getNutrCont5().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont5()));
            dto.setSalt(data.getNutrCont6().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont6()));
            dto.setCholesterol(data.getNutrCont7().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont7()));
            dto.setSaturatedFat(data.getNutrCont8().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont8()));
            dto.setTransFat(data.getNutrCont9().isEmpty() ? 0F : Float.parseFloat(data.getNutrCont9()));
            return dto;
        }).collect(Collectors.toList());
    }
}