package com.hackerton.fit.domain.user.dto;

import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;

import java.util.List;

public record User(
    String userId,

    String userName,

    String userPassword,

    Float height,

    Float weight,

    Float activityLevel,

    Long age,

    List<MealTimeEntity> mealTimeEntities

    ){
    public static User withId(
            String userId,
            String userName,
            String userPassword,
            Float height,
            Float weight,
            Float activityLevel,
            Long age,
            List<MealTimeEntity> mealTimeEntities){
        return new User(userId, userName, userPassword, height, weight, activityLevel, age, mealTimeEntities);
    }
}
