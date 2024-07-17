package com.hackerton.fit.domain.user.dto.req;

public record UserUpdateReq(
        String userId,
        String gender,
        Float height,
        Float weight,
        Float activityLevel,
        Long age
) {
}
