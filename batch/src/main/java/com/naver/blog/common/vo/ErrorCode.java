package com.naver.blog.common.vo;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // Common
    INVALID_INPUT_VALUE(400, "C000", "요청 값 및 URL을 확인해주세요"),
    HANDLE_AUTH_DENIED(401, "C001", "로그인을 확인해주세요"),
    HANDLE_ACCESS_DENIED(403, "C003", "권한을 확인해주세요"),
    HANDLE_NOT_FOUND(404, "C004", "URL을 확인해주세요"),
    METHOD_NOT_ALLOWED(405, "C005", "요청 값을 확인해주세요"),
    INVALID_METHOD(415, "C015", "요청 메소드를 확인해주세요"),

    INVALID_VALUE(400, "C100", "입력 값을 확인해주세요"),
    HANDLE_AUTH_NONE(401, "C101", "회원 정보가 없습니다"),
    HANDLE_USER_EXISTS(405, "C105", "이미 회원 정보가 존재합니다"),
    
    INTERNAL_SERVER_ERROR(500, "S000", "서버 담당자한테 문의해주세요"),

    CHECK_CURRENT_POINT(500, "S000", "소유하고 있는 포인트를 확인해주세요"),
    CHECK_CARGE_STATUS(500, "S000", "기 납부된 건입니다"),
    ;

    private int status;
    private final String code;
    private final String message;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.message = message;
        this.code = code;
    }
}