package com.thoughtworks.gaia.common.exception;

public enum ErrorCode {
    // 0 ~ 2000, system error
    UNKNOWN(0),
    RESOURCE_NOT_FOUND(1),
    USER_EMPTY_USER_ID(40001),
    USER_EXISTS_USER_ID(40002),
    USER_INVALID_PHONE(40003),
    QUIZ_REPOSITORY_NOT_FOUND_BY_ID(50001);

    private final int code;

    ErrorCode(final int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
