package com.hackerton.fit.domain.user.entity;

import com.hackerton.fit.domain.mealTime.entity.MealTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@Getter
@Table(name = "tbl_user")
@DynamicUpdate
@SuperBuilder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", unique = true)
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Column(name = "gender")
    private String gender;

    @Column(name = "height")
    private Float height;

    @Column(name = "weight")
    private Float weight;

    @Column(name = "activity_level")
    private Float activityLevel;

    @Column(name = "age")

    private Long age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealTimeEntity> mealTimeEntities;

    public void update(String gender, Float height, Float weight, Float activityLevel, Long age) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.activityLevel = activityLevel;
        this.age = age;
    }
}
