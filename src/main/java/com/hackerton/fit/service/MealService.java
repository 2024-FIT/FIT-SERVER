package com.hackerton.fit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class MealService {
    private final RestTemplate restTemplate;

    public String getData(String foodName) {
        String uri = "http://openapi.foodsafetykorea.go.kr/api/sample/I2790/json/1/5/DESC_KOR=" + foodName;
        return restTemplate.getForObject(uri, String.class);
    }
}
