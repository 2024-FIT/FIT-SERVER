package com.hackerton.fit.global.infra.secutiry;

import com.hackerton.fit.domain.user.dto.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class CustomMemberDetails implements UserDetails {
    private Collection<? extends GrantedAuthority> authorities;
    private final User user;

    // 생성자
    public CustomMemberDetails(final User user, Collection<? extends GrantedAuthority> authorities) {
        this.user = user;
        this.authorities = authorities;
    }

    // UserDetails 인터페이스의 메서드 구현

    // 사용자명 반환
    @Override
    public String getUsername() {
        return user.userName();
    }

    // 사용자 권한 반환
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // 패스워드 반환 (실제 패스워드 반환 필요)
    @Override
    public String getPassword() {
        return user.userPassword();
    }

    // 계정 만료 여부 반환
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정 잠금 여부 반환
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 패스워드 만료 여부 반환
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 여부 반환
    @Override
    public boolean isEnabled() {
        return true;
    }
}
