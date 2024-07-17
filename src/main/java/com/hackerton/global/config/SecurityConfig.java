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

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        http
                .csrf(AbstractHttpConfigurer::disable) // csrf().disable()

                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/swagger-ui/**", "/v3/**").permitAll()
                                .requestMatchers("/auth/**").permitAll()
                                .requestMatchers("/stomp/**").permitAll()
                                .anyRequest()
                                .authenticated()
                );
        return http.build();
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                .httpBasic().disable()
//                .cors()
//                .and()
//                .csrf().disable()
//                .cors(cors->cors.configurationSource(corsConfigurationSource()))
//                .sessionManagement()
//
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//
//                .and()
//                .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilterBefore(jwtExceptionFilter, JwtExceptionFilter.class)
//
//                .authorizeHttpRequests()
//                .requestMatchers("/sign-in/**","/refresh/**","/test/**").permitAll()
//                .requestMatchers("/sign-up").permitAll()
//                .requestMatchers("/v3/api-docs/**", "/swagger-ui/**").permitAll()
//                .requestMatchers("/user").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().disable()
//                .exceptionHandling()
//                .accessDeniedHandler(accessDeniedHandler);
//
//        return http.build();
//    }



    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
