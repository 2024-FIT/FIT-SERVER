package com.hackerton.fit.global.exception.custom.jwt;

import com.hackerton.fit.global.exception.custom.user.UserNotFoundException;
import com.hackerton.fit.global.exception.error.BusinessException;
import com.hackerton.fit.global.exception.error.StatusEnums;

public class TokenTypeException extends BusinessException{
    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public TokenTypeException() {
        super(StatusEnums.INTERNAL_SERVER_ERROR);
    }
}
