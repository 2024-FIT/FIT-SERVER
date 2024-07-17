package com.hackerton.fit.domain.meal.repository;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<MealEntity, Long> {

}
