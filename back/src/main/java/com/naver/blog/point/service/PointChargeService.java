package com.naver.blog.point.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.naver.blog.point.dao.PointChargeDao;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class PointChargeService {
	private final PointChargeDao pointChargeDao;
	
	public Object sampleData() {
		return pointChargeDao.sampleData();
	}
	
}
