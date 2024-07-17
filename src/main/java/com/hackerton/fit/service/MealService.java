package com.hackerton.fit.service;

import com.hackerton.fit.dto.NutritionDataDTO;
import com.hackerton.fit.entity.FoodDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MealService {

    private final RestTemplate restTemplate;
    private final String apiUrl = "http://openapi.foodsafetykorea.go.kr/api/sample/I2790/json/1/5/DESC_KOR=감자튀김";

    public List<NutritionDataDTO> fetchAndTransformData(String food) {
        FoodDataResponse foodDataResponse = restTemplate.getForObject(apiUrl, FoodDataResponse.class);
        if (foodDataResponse != null) {
            FoodDataResponse.FoodData foodData = foodDataResponse.getFoodData();
            return transformData(foodData);
        }
        return List.of();
    }

    private List<NutritionDataDTO> transformData(FoodDataResponse.FoodData foodData) {
        return foodData.getRow().stream().map(data -> {
            NutritionDataDTO dto = new NutritionDataDTO();
            dto.setDescKor(data.getDescKor());
            dto.setNutrCont1(Float.parseFloat(data.getNutrCont1()));
            dto.setNutrCont2(Float.parseFloat(data.getNutrCont2()));
            dto.setNutrCont3(Float.parseFloat(data.getNutrCont3()));
            dto.setNutrCont4(Float.parseFloat(data.getNutrCont4()));
            dto.setNutrCont5(Float.parseFloat(data.getNutrCont5()));
            dto.setNutrCont6(Float.parseFloat(data.getNutrCont6()));
            dto.setNutrCont7(Float.parseFloat(data.getNutrCont7()));
            dto.setNutrCont8(Float.parseFloat(data.getNutrCont8()));
            dto.setNutrCont9(Float.parseFloat(data.getNutrCont9()));
            return dto;
        }).collect(Collectors.toList());
    }
}