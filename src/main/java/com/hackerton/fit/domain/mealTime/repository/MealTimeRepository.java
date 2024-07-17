package com.hackerton.fit.domain.mealTime.repository;

import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealTimeRepository extends JpaRepository<MealTimeEntity, Long> {

}
