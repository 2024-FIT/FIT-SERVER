package com.hackerton.fit.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerton.fit.entity.FoodDataEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class MealClient {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public FoodDataEntity getData(String foodName) {
        String uri = "http://openapi.foodsafetykorea.go.kr/api/sample/I2790/json/1/5/DESC_KOR=" + foodName;
        String response = restTemplate.getForObject(uri, String.class);

        try {
            return objectMapper.readValue(response, FoodDataEntity.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
