package com.hackerton.fit.global.exception.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum StatusEnums {
    //smtp
    NOT_DUPLICATED_AUTH_CODE(400, "Not Duplicated AuthCode"),
    EXPIRED_TOKEN(401 , "Expired token"),
    INVALID_TOKEN(401, "Invalid token"),
    REFRESH_TOKEN_NOT_FOUND(401,"RefreshToken not found"),
    MALFORMED_JWT(400, "Jwt is malformed"),
    UNSUPPORTED_JWT(400, "Jwt is unsupported"),
    ILLEGAL_ARGUMENT(400, "IllegalArgumentException occurred"),

    // general
    OK(200,"OK"),
    CREATED(201,"Created"),
    BAD_REQUEST(400, "Bad request"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),

    //user
    MEMBER_NOT_EXISTS(403, "Member Not exists"),
    MEMBER_EXISTS(403, "Member exists"),
    USER_NOT_COINCIDE(401, "User not coincide"),
    USER_NOT_FOUND(404, "User not found"),
    NOT_AUTHENTICATED(401, "NotAuthenticated"),
    PERMISSION_DENIED(403, "Permission denied"),
    WITHDRAWAL_MEMBER(400, "Withdrawal member"),
    PASSWORD_WRONG(401, "Password is wrong"),

    TOKEN_NOT_PROVIDED(400, "잘못된 토큰"),
    CLOUD_EXCEPTION(500,"클라우드 에러")
    ;

    private final int statusCode;
    private final String message;
}
