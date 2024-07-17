package com.hackerton.fit.domain.mealTime.dto;

import com.hackerton.fit.domain.meal.dto.NutritionDataDTO;
import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import com.hackerton.fit.domain.mealTime.service.enums.MealTimeEnums;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MealTimeReq {
    private LocalDate time;

    private MealTimeEnums mealTimeEnum;

    private NutritionDataDTO meal;

    public MealTimeEntity toEntity(MealEntity mealEntity) {
        return MealTimeEntity.builder()
                .time(time)
                .mealTimeEnum(mealTimeEnum)
                .meal(mealEntity)
                .build();
    }
}
