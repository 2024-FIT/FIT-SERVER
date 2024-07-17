package com.hackerton.fit.domain.meal.entity;

import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import com.hackerton.fit.global.common.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
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

    private String FOOD_CD;

    private Long NUTR_CONT1;

    private Long NUTR_CONT2;

    private Long NUTR_CONT3;

    private Long NUTR_CONT4;

    private Long NUTR_CONT5;

    private Long NUTR_CONT6;

    private Long NUTR_CONT7;

    private Long NUTR_CONT8;

    private Long NUTR_CONT9;

    @OneToMany(mappedBy = "meal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealTimeEntity> mealTimeEntities;

}
