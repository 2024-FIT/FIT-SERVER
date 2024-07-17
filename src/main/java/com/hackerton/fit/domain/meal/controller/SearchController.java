package com.hackerton.fit.domain.meal.controller;

import com.hackerton.fit.domain.meal.dto.NutritionDataDTO;
import com.hackerton.fit.domain.meal.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meal")
public class SearchController {
    private final MealService mealService;

    @GetMapping("/search")
    public List<NutritionDataDTO> foodSearch(@RequestParam(name = "food") String food) {
         return mealService.fetchAndTransformData(food);
    }
}
