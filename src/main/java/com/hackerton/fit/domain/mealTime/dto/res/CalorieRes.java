package com.hackerton.fit.domain.mealTime.dto.res;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;

import java.time.LocalDate;

public record CalorieRes(
        LocalDate date,
        Float calorie
) {
    public static CalorieRes withId(MealTimeEntity mealTime) {
        return new CalorieRes(mealTime.getTime(),
                mealTime.getMeal().getCalorie()
        );
    }
}
