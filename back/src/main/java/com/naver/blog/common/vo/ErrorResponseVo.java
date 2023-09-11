package com.naver.blog.common.vo;

import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
//@NoArgsConstructor //(access = AccessLevel.PROTECTED)
@AllArgsConstructor //(access = AccessLevel.PROTECTED)
public class ErrorResponseVo {

    private int status;
    private String code;
    private String message;
//    private List<FieldError> errors;

//    @Getter
//    @NoArgsConstructor(access = AccessLevel.PROTECTED)
//    public static class FieldError {
//        private String field;
//        private String value;
//        private String reason;
//    }

	public static ErrorResponseVo of(ErrorCode handleAccessDenied) {
		ErrorResponseVo responseVo = new ErrorResponseVo(
				handleAccessDenied.getStatus()
				, handleAccessDenied.getCode()
				, handleAccessDenied.getMessage()
				);
		return responseVo;
	}

	public static ErrorResponseVo of(BusinessException e) {
		ErrorResponseVo responseVo = new ErrorResponseVo(
				500
				, e.getCode()
				, e.getMessage());
		return responseVo;
	}
}
