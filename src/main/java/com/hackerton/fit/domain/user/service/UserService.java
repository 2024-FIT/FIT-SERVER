package com.hackerton.fit.domain.user.service;

import com.hackerton.fit.domain.user.dto.User;
import com.hackerton.fit.domain.user.dto.req.UserReq;
import com.hackerton.fit.domain.user.dto.req.UserUpdateReq;
import com.hackerton.fit.domain.user.entity.UserEntity;
import com.hackerton.fit.domain.user.mapper.UserMapper;
import com.hackerton.fit.domain.user.repository.UserRepository;
import com.hackerton.fit.global.common.dto.AuthenticationRequest;
import com.hackerton.fit.global.common.dto.JsonWebTokenResponse;
import com.hackerton.fit.global.exception.custom.user.PasswordWrongException;
import com.hackerton.fit.global.infra.jwt.JwtUtil;
import com.hackerton.fit.global.infra.secutiry.CustomMemberDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class UserService {
    private static final String AUTH_CODE_PREFIX = "AuthCode_";
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    public void signup(UserReq userReq) {
        try {
            userRepository.save(UserEntity.builder()
                            .id(null)
                            .userId(userReq.getId())
                    .userName(userReq.getName())
                    .userPassword(new BCryptPasswordEncoder().encode(userReq.getPassword()))
                    .height(userReq.getHeight())
                    .weight(userReq.getWeight())
                    .age(userReq.getAge())
                    .activityLevel(userReq.getActivityLevel())
                    .build());
        } catch (Exception e) {
            throw new RuntimeException("Failed to save user", e);
        }
    }

    public JsonWebTokenResponse auth(AuthenticationRequest request) {
        UserEntity userEntity = userRepository.findByUserId(request.getId());

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with id: " + request.getId());
        }

        User user = userMapper.toDomain(userEntity);
        if (!new BCryptPasswordEncoder().matches(request.getPassword(), userEntity.getUserPassword())) {
            throw new PasswordWrongException();
        }

        UserDetails userDetails = new CustomMemberDetails(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user1 = ((CustomMemberDetails) authentication.getPrincipal()).getUser();

        return JsonWebTokenResponse.builder()
                .accessToken(jwtUtil.generateAccessToken(user1.userId()))
                .refreshToken(jwtUtil.generateRefreshToken(user1.userId()))
                .build();
    }

    public UserEntity getCurrentUser(String username) {
        return userRepository.findByUserId(username);
    }

    public void update(UserUpdateReq req){
        UserEntity user = userRepository.findByUserId(req.userId());
        user.update(req.gender(), req.height(), req.weight(), req.activityLevel(), req.age());
        userRepository.save(user);
    }
}
