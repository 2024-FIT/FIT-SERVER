package com.hackerton.fit.domain.meal.entity;

import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import com.hackerton.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Getter
@Table(name = "tbl_meal")
@DynamicUpdate
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MealEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealId;

    private String descKor;

    private Float calorie;

    private Float carbohydrate;

    private Float protein;

    private Float province;

    private Float sugar;

    private Float salt;

    private Float cholesterol;

    private Float saturatedFat;

    private Float transFat;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealTimeEntity> mealTimeEntities;
}
