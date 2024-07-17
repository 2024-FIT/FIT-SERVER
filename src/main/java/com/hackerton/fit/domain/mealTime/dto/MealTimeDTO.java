package com.hackerton.fit.domain.mealTime.dto;

import com.hackerton.fit.domain.mealTime.service.enums.MealTimeEnums;
import lombok.Data;

import java.sql.Date;

@Data
public class MealTimeDTO {
    private Date date;

    private MealTimeEnums mealTimeEnum;

    private Long userId;

//    private String
}
