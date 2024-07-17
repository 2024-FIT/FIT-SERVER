package com.hackerton.fit.domain.meal.service;

import com.hackerton.fit.domain.meal.dto.NutritionDataDTO;
import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.meal.repository.MealRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    @Transactional
    public MealEntity save(NutritionDataDTO nutritionDataDTO) {
        Optional<MealEntity> existingEntity = mealRepository.findByDescKor(nutritionDataDTO.getDescKor());
        return existingEntity.orElseGet(() -> mealRepository.save(nutritionDataDTO.toEntity()));
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
