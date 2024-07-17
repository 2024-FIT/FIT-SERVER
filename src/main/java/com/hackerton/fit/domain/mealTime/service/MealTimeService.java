package com.hackerton.fit.domain.mealTime.service;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.meal.service.MealService;
import com.hackerton.fit.domain.mealTime.dto.DateReq;
import com.hackerton.fit.domain.mealTime.dto.MealTimeReq;
import com.hackerton.fit.domain.mealTime.dto.res.CalorieRes;
import com.hackerton.fit.domain.mealTime.dto.res.MealTimeRes;
import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import com.hackerton.fit.domain.mealTime.repository.MealTimeRepository;
import com.hackerton.fit.domain.user.dto.User;
import com.hackerton.fit.domain.user.entity.UserEntity;
import com.hackerton.fit.domain.user.mapper.UserMapper;
import com.hackerton.fit.domain.user.service.GetCurrentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;
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
    private final WebInvocationPrivilegeEvaluator privilegeEvaluator;


    public void save(MealTimeReq mealTimeReq) {
        User user = getCurrentService.getMemberDetails().getUser();
        UserEntity userEntity = userMapper.toJpa(user);

//        User user = getCurrentService.getUser();
//        UserEntity userEntity = userMapper.toJpa(user);
        MealEntity meal = mealService.save(mealTimeReq.getMeal());

        mealTimeRepository.save(mealTimeReq.toEntity(meal, userEntity));
    }

    public List<CalorieRes> findCalories(DateReq dates) {
        ArrayList<CalorieRes> calories = new ArrayList<>();
        for (MealTimeEntity mealTimeEntity : mealTimeRepository.findAllByTimeBetween(dates.getStartDay(), dates.getEndDay())) {
            CalorieRes calorieRes = CalorieRes.withId(mealTimeEntity);
            calories.add(calorieRes);
        };

        return calories;
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
