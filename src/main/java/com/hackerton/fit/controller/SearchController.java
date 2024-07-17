package com.hackerton.fit.controller;

import com.hackerton.fit.dto.FoodDataDto;
import com.hackerton.fit.entity.FoodDataEntity;
import com.hackerton.fit.service.MealService;
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
    public List<FoodDataDto> index(@RequestParam String food) {
         return mealService.getData(food);
    }
}
