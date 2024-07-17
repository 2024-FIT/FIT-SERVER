package com.hackerton.fit.domain.meal.controller;

import com.hackerton.fit.domain.meal.service.MealService;
import com.hackerton.fit.dto.NutritionDataDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SearchController {
    private final MealService mealService;

    @GetMapping("/search")
    public List<NutritionDataDTO> index(@RequestParam String food) {
         return mealService.fetchAndTransformData(food);
    }
}
