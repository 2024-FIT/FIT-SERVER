package com.hackerton.global.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackerton.global.exception.error.BusinessException;
import com.hackerton.global.exception.error.StatusEnums;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class GlobalExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    )throws IOException {

        try {
            filterChain.doFilter(request,response);
        } catch (BusinessException e){
            StatusEnums errorCode = e.getErrorCode();
            writerErrorResponse(response, ErrorResponse.of(errorCode, errorCode.getMessage()));
        } catch (Exception e){
            writerErrorResponse(response, ErrorResponse.of(response.getStatus(),e.getMessage()));
        }
    }

    private void writerErrorResponse(HttpServletResponse response, ErrorResponse errorResponse) throws IOException{
        response.setStatus(errorResponse.getStatus());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(response.getWriter(), errorResponse);
    }

}