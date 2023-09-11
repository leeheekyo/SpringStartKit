package com.naver.blog.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleInterceptor implements HandlerInterceptor{
//	public static Logger logger = new Logger(null, logger, null);
	@Override
	public boolean preHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		log.info(request.getMethod() + " : " + request.getRequestURI());
		
		return true;
	}

	// controller의 handler가 끝나면 처리됨
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response,
			Object obj, ModelAndView mav)
			throws Exception {
		log.info("response : " + response.getStatus());
	}

	// view까지 처리가 끝난 후에 처리됨
//	@Override
//	public void afterCompletion(
//			HttpServletRequest request, HttpServletResponse response,
//			Object obj, Exception e)
//			throws Exception {
//	}
}
