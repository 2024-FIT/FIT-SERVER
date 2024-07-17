package com.hackerton.fit.domain.meal.dto;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class NutritionDataDTO {
    private Long _id;

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

    public NutritionDataDTO() {

    }

    public NutritionDataDTO(MealEntity mealEntity) {
        this._id = mealEntity.getMealId();
        this.descKor = mealEntity.getDescKor();
        this.calorie = mealEntity.getCalorie();
        this.carbohydrate = mealEntity.getCarbohydrate();
        this.protein = mealEntity.getProtein();
        this.province = mealEntity.getProvince();
        this.sugar = mealEntity.getSugar();
        this.salt = mealEntity.getSalt();
        this.cholesterol = mealEntity.getCholesterol();
        this.saturatedFat = mealEntity.getSaturatedFat();
        this.transFat = mealEntity.getTransFat();
    }

    public MealEntity toEntity() {
        return MealEntity.builder()
                .descKor(descKor)
                .calorie(calorie)
                .carbohydrate(carbohydrate)
                .protein(protein)
                .province(province)
                .sugar(sugar)
                .salt(salt)
                .cholesterol(cholesterol)
                .saturatedFat(saturatedFat)
                .transFat(transFat)
                .build();
    }
}
