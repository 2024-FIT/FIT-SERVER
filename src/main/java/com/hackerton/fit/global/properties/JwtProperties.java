package com.hackerton.fit.global.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("application.jwt")
public class JwtProperties {
    private String secretKey;
    private Long accessExpiration;
    private Long refreshExpiration;
}

