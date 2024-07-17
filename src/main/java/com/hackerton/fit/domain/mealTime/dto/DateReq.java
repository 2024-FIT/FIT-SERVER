package com.hackerton.fit.domain.mealTime.dto;

import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
public class DateReq {
    LocalDate startDay;
    LocalDate endDay;

    public DateReq(LocalDate startDay, LocalDate endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
    }
}
