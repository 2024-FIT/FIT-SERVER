package com.hackerton.global.exception.custom.jwt;

import com.hackerton.global.exception.custom.user.UserNotFoundException;
import com.hackerton.global.exception.error.BusinessException;
import com.hackerton.global.exception.error.StatusEnums;

public class TokenTypeException extends BusinessException{
    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public TokenTypeException() {
        super(StatusEnums.INTERNAL_SERVER_ERROR);
    }
}
