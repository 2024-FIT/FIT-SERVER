package com.hackerton.fit.global.exception.custom.user;

import com.hackerton.fit.global.exception.error.BusinessException;
import com.hackerton.fit.global.exception.error.StatusEnums;

public class PasswordWrongException extends BusinessException {
    public static final BusinessException EXCEPTION = new PasswordWrongException();

    public PasswordWrongException() {
        super(StatusEnums.PASSWORD_WRONG);
    }
}
