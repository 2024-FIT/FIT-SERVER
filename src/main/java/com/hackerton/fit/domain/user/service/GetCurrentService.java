package com.hackerton.fit.domain.user.service;

import com.hackerton.fit.domain.user.dto.User;
import com.hackerton.fit.domain.user.entity.UserEntity;
import com.hackerton.fit.global.infra.secutiry.CustomMemberDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@Component
public class GetCurrentService {
    public User getUser() {
        return getMemberDetails().getUser();
    }

    private CustomMemberDetails getMemberDetails() {
        return ((CustomMemberDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
    }
}
