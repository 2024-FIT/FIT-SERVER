package com.hackerton.fit.domain.mealTime.entity;

import com.hackerton.fit.domain.meal.entity.MealEntity;
import com.hackerton.fit.domain.mealTime.service.enums.MealTimeEnums;
import com.hackerton.fit.domain.user.entity.UserEntity;
import com.hackerton.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "tbl_meal_time")
@DynamicUpdate
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MealTimeEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealTimeId;

    private LocalDate time;

    private Long allCalorie;

    private MealTimeEnums mealTimeEnums;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "meal_id")
    private MealEntity meal;
}
