package com.hackerton.fit.domain.mealTime.service;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.meal.service.MealService;
import com.hackerton.fit.domain.mealTime.dto.MealTimeDTO;
import com.hackerton.fit.domain.mealTime.dto.MealTimeResponse;
import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import com.hackerton.fit.domain.mealTime.repository.MealTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealTimeService {
    private final MealTimeRepository mealTimeRepository;
    private final MealService mealService;


    public void save(MealTimeResponse mealTimeResponse) {

        MealEntity meal = mealService.save(mealTimeResponse.getMeal());

        mealTimeRepository.save(mealTimeResponse.toEntity(meal));
    }

    public List<MealTimeDTO> findByTime(LocalDate time) {
        List<MealTimeDTO> mealTimeDTOS = new ArrayList<>();
        for (MealTimeEntity entity :mealTimeRepository.findAllByTime(time)) {
            mealTimeDTOS.add(new MealTimeDTO(entity));
        }
        return mealTimeDTOS;
    }
}
