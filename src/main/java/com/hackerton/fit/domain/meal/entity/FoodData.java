package com.hackerton.fit.domain.meal.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class FoodData {
    @JsonProperty("total_count")
    private String totalCount;
    @JsonProperty("row")
    private List<FoodItem> row;
}
