package com.naver.blog.common.service.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.blog.common.service.PointManageService;

import lombok.extern.slf4j.Slf4j;

@Service("KakaoPointManageService")
@Transactional
@Slf4j
public class KakaoPointManageServiceImpl implements PointManageService {

	/**
	 * @lastAuth : lee heekyo
	 * @lastModifyDate : 2023-08-19
	 * @param userId : 납부자 고객 식별값
	 * @description : 사용자 포인트 조회
	 */
	@Override
	public BigInteger searchPoint(BigInteger userId) {
		log.info("call to search point");
		return BigInteger.valueOf(Integer.MAX_VALUE);
	}
	
	/**
	 * @lastAuth : lee heekyo
	 * @lastModifyDate : 2023-08-19
	 * @param userId : 납부자 고객 식별값
	 * @param amount : 납부 금액
	 * @description : 사용자 포인트 납부 요청
	 */
	@Override
	public void paymentPoint(BigInteger userId, BigInteger amount) {
		log.info("call to payment");
		// TODO Auto-generated method stub
	}

}
