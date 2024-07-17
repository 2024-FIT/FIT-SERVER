package com.hackerton.fit.domain.mealTime.dto.res;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.mealTime.service.enums.MealTimeEnums;

import java.time.LocalDate;

public record MealTimeRes(
        String mealTimeEnum,
        Long mealId,
        String descKor,
        Float calorie,
        Float carbohydrate,
        Float protein,
        Float province,
        Float sugar,
        Float salt,
        Float cholesterol,
        Float saturatedFat,
        Float transFat
) {
    public static MealTimeRes withId(String mealTimeEnum, MealEntity meal) {
        return new MealTimeRes(mealTimeEnum,
                meal.getMealId(),
                meal.getDescKor(),
                meal.getCalorie(),
                meal.getCarbohydrate(),
                meal.getProtein(),
                meal.getProvince(),
                meal.getSugar(),
                meal.getSalt(),
                meal.getCholesterol(),
                meal.getSaturatedFat(),
                meal.getTransFat()
        );
    }
}
