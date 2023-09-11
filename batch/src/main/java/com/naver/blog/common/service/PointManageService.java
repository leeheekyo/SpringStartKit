package com.naver.blog.common.service;

import java.math.BigInteger;


public interface PointManageService {
	/**
	 * @lastAuth : lee heekyo
	 * @lastModifyDate : 2023-08-19
	 * @param userId : 납부자 고객 식별값
	 * @description : 사용자 포인트 조회
	 */
	public BigInteger searchPoint(final BigInteger userId);

	/**
	 * @lastAuth : lee heekyo
	 * @lastModifyDate : 2023-08-19
	 * @param userId : 납부자 고객 식별값
	 * @param amount : 납부 금액
	 * @description : 사용자 포인트 납부 요청
	 */
	public void paymentPoint(final BigInteger userId, final BigInteger amount);
	
}
