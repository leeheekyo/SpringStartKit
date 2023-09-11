package com.naver.blog.common.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class BusinessException extends RuntimeException {
	private final String code;
    private final String message;
    
    public BusinessException(ErrorCode errorCode) {
		this.code = errorCode.getCode();
		this.message = errorCode.getMessage();
	}

}
