package com.hackerton.fit.domain.mealTime.dto;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import com.hackerton.fit.domain.mealTime.service.enums.MealTimeEnums;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MealTimeDTO {
    private LocalDate time;

    private MealTimeEnums mealTimeEnum;

    private MealEntity meal;

    public MealTimeDTO() {}

    public MealTimeDTO(MealTimeEntity mealTimeEntity) {
        this.time = mealTimeEntity.getTime();
        this.mealTimeEnum = mealTimeEntity.getMealTimeEnum();
        this.meal = mealTimeEntity.getMeal();
    }
}
