package com.hackerton.fit.domain.meal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class FoodItem {
    @JsonProperty("NUTR_CONT8")
    private String nutrCont8;
    @JsonProperty("NUTR_CONT9")
    private String nutrCont9;
    @JsonProperty("NUTR_CONT4")
    private String nutrCont4;
    @JsonProperty("NUTR_CONT5")
    private String nutrCont5;
    @JsonProperty("NUTR_CONT6")
    private String nutrCont6;
    @JsonProperty("NUM")
    private String num;
    @JsonProperty("NUTR_CONT7")
    private String nutrCont7;
    @JsonProperty("NUTR_CONT1")
    private String nutrCont1;
    @JsonProperty("NUTR_CONT2")
    private String nutrCont2;
    @JsonProperty("SUB_REF_NAME")
    private String subRefName;
    @JsonProperty("NUTR_CONT3")
    private String nutrCont3;
    @JsonProperty("RESEARCH_YEAR")
    private String researchYear;
    @JsonProperty("MAKER_NAME")
    private String makerName;
    @JsonProperty("GROUP_NAME")
    private String groupName;
    @JsonProperty("SERVING_SIZE")
    private String servingSize;
    @JsonProperty("SERVING_UNIT")
    private String servingUnit;
    @JsonProperty("SAMPLING_REGION_NAME")
    private String samplingRegionName;
    @JsonProperty("SAMPLING_MONTH_CD")
    private String samplingMonthCd;
    @JsonProperty("SAMPLING_MONTH_NAME")
    private String samplingMonthName;
    @JsonProperty("DESC_KOR")
    private String descKor;
    @JsonProperty("SAMPLING_REGION_CD")
    private String samplingRegionCd;
    @JsonProperty("FOOD_CD")
    private String foodCd;
}
