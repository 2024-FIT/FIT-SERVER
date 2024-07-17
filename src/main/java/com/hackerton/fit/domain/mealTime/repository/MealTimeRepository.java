package com.hackerton.fit.domain.mealTime.repository;

import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MealTimeRepository extends JpaRepository<MealTimeEntity, Long> {
    List<MealTimeEntity> findAllByTimeBetween(LocalDate start, LocalDate end);
    List<MealTimeEntity> findAllByTime(LocalDate time);
}
