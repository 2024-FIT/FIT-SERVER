package com.hackerton.fit.domain.mealTime.controller;

import com.hackerton.fit.domain.mealTime.dto.MealTimeReq;
import com.hackerton.fit.domain.mealTime.dto.res.MealTimeRes;
import com.hackerton.fit.domain.mealTime.service.MealTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/meal-time")
public class MealTimeController {
    private final MealTimeService mealTimeService;

    @PostMapping("/save")
    public void insertMealTime(
            @RequestBody MealTimeReq mealTimeReq) {
        mealTimeService.save(mealTimeReq);
    }

    @GetMapping("/today")
    public List<MealTimeRes> getTodayMealTime(@RequestParam LocalDate day) {
        return mealTimeService.findByTime(day);
    }
}
