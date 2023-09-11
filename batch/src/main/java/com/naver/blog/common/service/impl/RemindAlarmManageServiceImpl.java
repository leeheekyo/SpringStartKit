package com.naver.blog.common.service.impl;

import java.math.BigInteger;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.blog.common.service.AlarmManageService;

import lombok.extern.slf4j.Slf4j;

@Service("RemindAlarmManageServiceImpl")
@Transactional
@Slf4j
public class RemindAlarmManageServiceImpl implements AlarmManageService {
	@Override
	public BigInteger sendAlarm(BigInteger recvUserId, String title, String body) {
		log.info("send alarm!!");
		
		return null;
	}

	@Override
	public Object searchAlarmStatus(BigInteger recvUserId, BigInteger alarmId) {
		log.info("check alarm!!");
		
		return null;
	}

}
