package com.hackerton.global.infra.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerton.global.exception.ErrorResponse;
import com.hackerton.global.exception.error.StatusEnums;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;

import java.io.IOException;

@AllArgsConstructor
public class JwtExceptionFilter {
    private final ObjectMapper objectMapper;

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            setErrorResponse(response, StatusEnums.EXPIRED_TOKEN);
        } catch (MalformedJwtException e) {
            setErrorResponse(response, StatusEnums.MALFORMED_JWT);
        } catch (UnsupportedJwtException e) {
            setErrorResponse(response, StatusEnums.UNSUPPORTED_JWT);
        } catch (IllegalArgumentException e) {
            setErrorResponse(response, StatusEnums.ILLEGAL_ARGUMENT);
        }
    }

    private void setErrorResponse(HttpServletResponse response, StatusEnums error) {
        try {
            responseToClient(response, ErrorResponse.of(error, error.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void responseToClient(HttpServletResponse response, ErrorResponse errorResponse) throws IOException {
        response.setStatus(errorResponse.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }

}
