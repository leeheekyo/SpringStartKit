package com.naver.blog.interceptor;

import java.nio.file.AccessDeniedException;

import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.naver.blog.common.vo.BusinessException;
import com.naver.blog.common.vo.ErrorCode;
import com.naver.blog.common.vo.ErrorResponseVo;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     *  javax.validation.Valid or @Validated 으로 binding error 발생시 발생한다.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponseVo> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("handleMethodArgumentNotValidException", e);
        final ErrorResponseVo response = ErrorResponseVo.of(ErrorCode.INVALID_INPUT_VALUE); //, e.getBindingResult()
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * @ModelAttribut 으로 binding error 발생시 BindException 발생한다.
     */
    @ExceptionHandler(BindException.class)
    protected ResponseEntity<ErrorResponseVo> handleBindException(BindException e) {
        log.error("handleBindException", e);
        final ErrorResponseVo response = ErrorResponseVo.of(ErrorCode.INVALID_INPUT_VALUE); //, e.getBindingResult()
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * enum type 일치하지 않아 binding 못할 경우 발생
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<ErrorResponseVo> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        log.error("handleMethodArgumentTypeMismatchException", e);
        final ErrorResponseVo response = ErrorResponseVo.of(ErrorCode.INVALID_METHOD); // e
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<ErrorResponseVo> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("handleHttpRequestMethodNotSupportedException", e);
        final ErrorResponseVo response = ErrorResponseVo.of(ErrorCode.METHOD_NOT_ALLOWED);
        return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * Authentication 객체가 필요한 권한을 보유하지 않은 경우 발생합
     */
    @ExceptionHandler(AccessDeniedException.class)
    protected ResponseEntity<ErrorResponseVo> handleAccessDeniedException(AccessDeniedException e) {
        log.error("handleAccessDeniedException", e);
        final ErrorResponseVo response = ErrorResponseVo.of(ErrorCode.HANDLE_ACCESS_DENIED);
        return new ResponseEntity<>(response, HttpStatus.valueOf(ErrorCode.HANDLE_ACCESS_DENIED.getStatus()));
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorResponseVo> handleBusinessException(final BusinessException e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorResponseVo response = ErrorResponseVo.of(e);
        return new ResponseEntity<>(response, HttpStatus.valueOf(500));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponseVo> handleException(Exception e) {
        log.error("handleEntityNotFoundException", e);
        final ErrorResponseVo response = ErrorResponseVo.of(ErrorCode.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
