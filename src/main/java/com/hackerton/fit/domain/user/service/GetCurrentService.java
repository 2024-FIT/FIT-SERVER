package com.hackerton.fit.domain.user.service;

import com.hackerton.fit.domain.user.dto.User;
import com.hackerton.fit.global.infra.secutiry.CustomMemberDetails;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class GetCurrentService {
    public User getUser() {
        return getMemberDetails().getUser();
    }

    private CustomMemberDetails getMemberDetails() {
        return ((CustomMemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
