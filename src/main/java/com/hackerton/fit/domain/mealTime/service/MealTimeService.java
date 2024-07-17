package com.hackerton.fit.domain.mealTime.service;

import com.hackerton.fit.domain.mealTime.dto.MealTimeDTO;
import com.hackerton.fit.domain.mealTime.repository.MealTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MealTimeService {
    private final MealTimeRepository mealTimeRepository;

    public void save(MealTimeDTO mealTimeDTO) {

    }
}
