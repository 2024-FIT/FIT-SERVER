package com.hackerton.fit.global.exception.custom.user;

import com.hackerton.fit.global.exception.error.BusinessException;
import com.hackerton.fit.global.exception.error.StatusEnums;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(StatusEnums.INTERNAL_SERVER_ERROR);
    }

}
