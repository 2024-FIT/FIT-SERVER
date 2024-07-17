package com.hackerton.fit.global.infra.jwt;

import com.hackerton.fit.domain.user.dto.User;
import com.hackerton.fit.domain.user.mapper.UserMapper;
import com.hackerton.fit.domain.user.repository.UserRepository;
import com.hackerton.fit.global.exception.custom.jwt.TokenTypeException;
import com.hackerton.fit.global.infra.secutiry.CustomMemberDetails;
import com.hackerton.fit.global.properties.JwtProperties;
import io.jsonwebtoken.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    private final JwtProperties jwtProperties;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String generateAccessToken(String id) {
        Long accessExpiration = jwtProperties.getAccessExpiration();
        if (accessExpiration == null) {
            throw new IllegalStateException("접근 만료 설정이 null입니다");
        }
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "ACCESS")
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getAccessExpiration()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
                .compact();
    }

    public String generateRefreshToken(String id) {
        return Jwts.builder()
                .setHeaderParam(Header.JWT_TYPE, "REFRESH")
                .setSubject(id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getRefreshExpiration()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecretKey())
                .compact();
    }

    @Transactional
    public Authentication getAuthentication(String accessToken) {
        final Jws<Claims> claims = (Jws<Claims>) getClaims(accessToken);

        if (isWrongType(claims, TokenType.ACCESS)) {
            throw TokenTypeException.EXCEPTION;
        }

        UserEntity userEntity = userRepository.findByUserId(claims.getBody().getSubject());

        User user = userMapper.toDomain(userEntity);

        final CustomMemberDetails details = new CustomMemberDetails(user);

        return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
    }

    public String resolveToken(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }
        return null;
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(jwtProperties.getSecretKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isWrongType(final Jws<Claims> claims, final TokenType tokenType) {
        return !(claims.getHeader().get(Header.JWT_TYPE).equals(tokenType.toString()));
    }
}
