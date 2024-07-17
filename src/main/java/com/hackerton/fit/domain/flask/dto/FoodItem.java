package com.hackerton.fit.domain.flask.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodItem {
    private String foodName;
    private int foodCalories;
    private String foodWeight;
}
