package com.hackerton.fit.domain.flask.dto.res;

import com.hackerton.fit.domain.flask.dto.FoodItem;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class DietResponse {
    private List<FoodItem> recommendedDiet;
}
