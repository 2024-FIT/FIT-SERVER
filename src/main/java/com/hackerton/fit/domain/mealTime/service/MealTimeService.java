package com.hackerton.fit.domain.mealTime.service;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.meal.service.MealService;
import com.hackerton.fit.domain.mealTime.dto.MealTimeReq;
import com.hackerton.fit.domain.mealTime.dto.res.MealTimeRes;
import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import com.hackerton.fit.domain.mealTime.repository.MealTimeRepository;
import com.hackerton.fit.domain.user.mapper.UserMapper;
import com.hackerton.fit.domain.user.service.GetCurrentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MealTimeService {
    private final MealTimeRepository mealTimeRepository;
    private final MealService mealService;
    private final GetCurrentService getCurrentService;
    private final UserMapper userMapper;


    public void save(MealTimeReq mealTimeReq) {
        MealEntity meal = mealService.save(mealTimeReq.getMeal());

        mealTimeRepository.save(mealTimeReq.toEntity(meal));
    }

    public List<MealTimeRes> findByTime(LocalDate time) {

        ArrayList<MealTimeRes> mealTimeDTOS = new ArrayList<>();

        for (MealTimeEntity entity :mealTimeRepository.findAllByTime(time)) {
            MealTimeRes mealTimeRes = MealTimeRes.withId(String.valueOf(entity.getMealTimeEnum()), entity.getMeal());
            mealTimeDTOS.add(mealTimeRes);
        }


        return mealTimeDTOS;
    }
}
