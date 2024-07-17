package com.hackerton.global.exception.custom.user;

import com.hackerton.global.exception.error.BusinessException;
import com.hackerton.global.exception.error.StatusEnums;

public class UserNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new UserNotFoundException();

    public UserNotFoundException() {
        super(StatusEnums.INTERNAL_SERVER_ERROR);
    }

}
