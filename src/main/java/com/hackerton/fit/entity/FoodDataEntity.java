package com.hackerton.fit.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class FoodDataEntity {
    @JsonProperty("I2790")
    private FoodData foodData;
}


