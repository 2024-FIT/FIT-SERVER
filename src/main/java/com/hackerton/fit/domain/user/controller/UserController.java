package com.hackerton.fit.domain.user.controller;

import com.hackerton.fit.domain.user.dto.req.UserReq;
import com.hackerton.fit.domain.user.dto.req.UserUpdateReq;
import com.hackerton.fit.domain.user.entity.UserEntity;
import com.hackerton.fit.domain.user.service.UserService;
import com.hackerton.fit.global.common.dto.AuthenticationRequest;
import com.hackerton.fit.global.common.dto.JsonWebTokenResponse;
import com.hackerton.fit.global.common.dto.response.Response;
import com.hackerton.fit.global.common.dto.response.ResponseData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "auth", description = "auth")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public UserEntity getUser(@RequestParam("user") String username) {
        return userService.getCurrentUser(username);
    }

    @PostMapping("/update-user")
    public void getUser(@RequestBody @Validated UserUpdateReq userEntity) {
        userService.update(userEntity);
    }

    @Operation(summary = "회원 가입", description = "회원 가입")
    @PostMapping("/signup")
    public Response signup(@Validated @RequestBody UserReq userReq) {
        userService.signup(userReq);
        return Response.of(HttpStatus.CREATED, "회원가입 성공");
    }

    @Operation(summary = "회원 인증", description = "회원 인증")
    @PostMapping("")
    public ResponseData<JsonWebTokenResponse> auth(@Validated @RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseData.of(HttpStatus.OK,"로그인 성공", userService.auth(authenticationRequest));
    }
}
