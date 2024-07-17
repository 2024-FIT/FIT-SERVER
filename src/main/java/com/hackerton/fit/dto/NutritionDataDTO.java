package com.hackerton.fit.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class NutritionDataDTO {
    private String descKor;
    private Float nutrCont1;
    private Float nutrCont2;
    private Float nutrCont3;
    private Float nutrCont4;
    private Float nutrCont5;
    private Float nutrCont6;
    private Float nutrCont7;
    private Float nutrCont8;
    private Float nutrCont9;
}
