package com.hackerton.fit.domain.user.mapper;

import com.hackerton.fit.domain.user.dto.User;
import com.hackerton.fit.domain.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {
    public User toDomain(UserEntity userEntity){
        return User.withId(
                userEntity.getUserId(),
                userEntity.getUserName(),
                userEntity.getUserPassword(),
                userEntity.getHeight(),
                userEntity.getWeight(),
                userEntity.getActivityLevel(),
                userEntity.getAge()
//                userEntity.getMealTimeEntities()
        );
    }
}
