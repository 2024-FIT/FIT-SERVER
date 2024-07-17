package com.hackerton.fit.domain.user.dto.req;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReq {
    @NotBlank
    private String id;

    @NotBlank(message = "password is required")
    @Size(min = 4, message = "비밀번호는 최소 4자리 이상으로 입력해 주세요")
    private String password;

    @NotBlank(message = "name is required")
    private String name;

    private String gender;

    @NotNull(message = "age is required")
    private Long age;

    @NotNull(message = "height is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private Float height;

    @NotNull(message = "weight is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private Float weight;

    @NotNull(message = "activityLevel is required")
    @DecimalMin(value = "0.0", inclusive = false)
    private Float activityLevel;
}
