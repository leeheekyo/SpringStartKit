package com.naver.blog.common.service;

import java.math.BigInteger;


public interface AlarmManageService {
	/**
	 * @lastAuth : lee heekyo
	 * @lastModifyDate : 2023-08-19
	 * @param recvUserId : 수신자 고객 식별값
	 * @param title : 알림 제목
	 * @param body : 알림 본문 내용
	 * @description : 알림 보내기
	 */
	public BigInteger sendAlarm(final BigInteger recvUserId, final String title, final String body);

	/**
	 * @lastAuth : lee heekyo
	 * @lastModifyDate : 2023-08-19
	 * @param recvUserId : 수신자 고객 식별값
	 * @param alarmId : 알림 식별값
	 * @description : 알림 상태 조회
	 */
	public Object searchAlarmStatus(final BigInteger recvUserId, final BigInteger alarmId);
	
}
