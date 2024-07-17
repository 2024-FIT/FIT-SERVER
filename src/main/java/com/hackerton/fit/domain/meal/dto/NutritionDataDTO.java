package com.hackerton.fit.domain.meal.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class NutritionDataDTO {
    private String descKor;
    private Float calorie;
    private Float carbohydrate;
    private Float protein;
    private Float province;
    private Float sugar;
    private Float salt;
    private Float cholesterol;
    private Float saturatedFat;
    private Float transFat;
}
