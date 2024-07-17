package com.hackerton.fit.domain.mealTime.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DateReq {
    LocalDate startDay;
    LocalDate endDay;
}
