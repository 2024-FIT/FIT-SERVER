package com.hackerton.fit.domain.user.service;

import com.hackerton.fit.domain.user.dto.User;
import com.hackerton.fit.global.infra.secutiry.CustomMemberDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class GetCurrentService {
//    public User getUser() {
//        return getMemberDetails().getUser();
//    }
//
//    private CustomMemberDetails getMemberDetails() {
//        return ((CustomMemberDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
//    }

    public CustomMemberDetails getMemberDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();

        if (!(principal instanceof CustomMemberDetails)) {
            throw new IllegalArgumentException("Authenticated principal is not of type CustomMemberDetails");
        }

        return (CustomMemberDetails) principal;
    }

    public CustomMemberDetails getUser() {
        return getMemberDetails();
    }
}
