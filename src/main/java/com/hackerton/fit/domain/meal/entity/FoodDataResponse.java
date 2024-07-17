package com.hackerton.fit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FoodDataResponse {

    @JsonProperty("I2790")
    private FoodData foodData;

    // Getters and Setters
    @Data
    public static class FoodData {
        @JsonProperty("total_count")
        private String totalCount;

        @JsonProperty("row")
        private List<NutritionData> row;

        @JsonProperty("RESULT")
        private Result result;

        // Getters and Setters
    }

    @Data
    public static class NutritionData {
        @JsonProperty("NUTR_CONT1")
        private String nutrCont1;

        @JsonProperty("NUTR_CONT2")
        private String nutrCont2;

        @JsonProperty("NUTR_CONT3")
        private String nutrCont3;

        @JsonProperty("NUTR_CONT4")
        private String nutrCont4;

        @JsonProperty("NUTR_CONT5")
        private String nutrCont5;

        @JsonProperty("NUTR_CONT6")
        private String nutrCont6;

        @JsonProperty("NUTR_CONT7")
        private String nutrCont7;

        @JsonProperty("NUTR_CONT8")
        private String nutrCont8;

        @JsonProperty("NUTR_CONT9")
        private String nutrCont9;

        @JsonProperty("DESC_KOR")
        private String descKor;

        // Getters and Setters
    }

    @Data
    public static class Result {
        @JsonProperty("MSG")
        private String msg;

        @JsonProperty("CODE")
        private String code;

        // Getters and Setters
    }
}
