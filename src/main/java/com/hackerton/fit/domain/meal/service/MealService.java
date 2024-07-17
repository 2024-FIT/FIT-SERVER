package com.hackerton.fit.domain.meal.service;

import com.hackerton.fit.domain.meal.dto.NutritionDataDTO;
import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.meal.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    public MealEntity save(NutritionDataDTO nutritionDataDTO) {
//        if (nutritionDataDTO.to)
        return mealRepository.save(nutritionDataDTO.toEntity());
    }

    public NutritionDataDTO findById(Long id) {
        Optional<MealEntity> optionalMealEntity = mealRepository.findById(id);
        if (optionalMealEntity.isPresent()) {
            MealEntity mealEntity = optionalMealEntity.get();
            return new NutritionDataDTO(mealEntity);
        } else {
            throw new IllegalArgumentException("식사가 없습니다 : " + id);
        }
    }
}
