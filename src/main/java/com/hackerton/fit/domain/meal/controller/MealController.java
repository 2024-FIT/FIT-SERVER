package com.hackerton.fit.domain.meal.controller;

import com.hackerton.fit.domain.meal.dto.NutritionDataDTO;
import com.hackerton.fit.domain.meal.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meal")
public class MealController {
    private final SearchService searchService;

    @GetMapping("/search")
    public List<NutritionDataDTO> foodSearch(@RequestParam(name = "food") String food) {
         return searchService.fetchAndTransformData(food);
    }

    @PostMapping("/add-meal")
    public void addMeal(@RequestBody NutritionDataDTO nutritionDataDTO) {

    }
}
