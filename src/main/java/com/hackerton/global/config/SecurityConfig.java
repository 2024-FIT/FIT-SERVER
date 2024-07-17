package com.hackerton.global.config;

import com.hackerton.global.infra.jwt.JwtExceptionFilter;
import com.hackerton.global.infra.jwt.JwtFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final AccessDeniedHandler accessDeniedHandler;
    private final JwtExceptionFilter jwtExceptionFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // SecurityContextHolder의 전략을 InheritableThreadLocal로 설정하여 자식 스레드가 부모 스레드의 보안 컨텍스트를 상속받도록 함
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);

        http
                // CSRF 보호 비활성화
                .csrf(AbstractHttpConfigurer::disable)

                // 요청에 대한 권한 부여 설정
                .authorizeHttpRequests(authorize -> authorize
                        // Swagger 관련 URL 패턴에 대해 모든 사용자에게 접근 허용
                        .requestMatchers(
                                "/v2/api-docs", "/v3/api-docs", "/v3/api-docs/**",
                                "/swagger-resources", "/swagger-resources/**",
                                "/configuration/ui", "/configuration/security",
                                "/swagger-ui/**", "/webjars/**", "/swagger-ui/index.html"
                        ).permitAll()
                        // 기타 특정 URL 패턴에 대해 모든 사용자에게 접근 허용
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/stomp/**").permitAll()
                        // 그 외의 모든 요청은 인증 필요
                        .anyRequest().authenticated()
                );

        // 설정을 완료하고 SecurityFilterChain 객체 반환
        return http.build();
    }
}
