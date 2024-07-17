package com.hackerton.fit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hackerton.fit.entity.FoodItem;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class FoodDataDto {
    // 음식이름
    @JsonProperty("DESC_KOR")
    private String foodName;
    // 열량
    @JsonProperty("NUTR_CONT1")
    private Integer calorie;
    // 탄수화물
    @JsonProperty("NUTR_CONT2")
    private Float carbohydrate;
    // 딘백질
    @JsonProperty("NUTR_CONT3")
    private Float protein;
    // 지방
    @JsonProperty("NUTR_CONT4")
    private Float province;
    // 당류
    @JsonProperty("NUTR_CONT5")
    private Float sugars;
    // 나트륨
    @JsonProperty("NUTR_CONT6")
    private Float salt;
    // 콜레스트롤
    @JsonProperty("NUTR_CONT7")
    private Float cholesterol;
    // 포화지방
    @JsonProperty("NUTR_CONT8")
    private Float saturatedFat;
    // 트렌스지방
    @JsonProperty("NUTR_CONT9")
    private Float transFat;

    public static FoodDataDto of(FoodItem foodItem){
        return new FoodDataDto(
                foodItem.getDescKor(),
                Integer.parseInt(foodItem.getNutrCont1()),
                Float.parseFloat(foodItem.getNutrCont2()),
                Float.parseFloat(foodItem.getNutrCont3()),
                Float.parseFloat(foodItem.getNutrCont4()),
                Float.parseFloat(foodItem.getNutrCont5()),
                Float.parseFloat(foodItem.getNutrCont6()),
                Float.parseFloat(foodItem.getNutrCont7()),
                Float.parseFloat(foodItem.getNutrCont8()),
                Float.parseFloat(foodItem.getNutrCont9())
        );
    }
}
