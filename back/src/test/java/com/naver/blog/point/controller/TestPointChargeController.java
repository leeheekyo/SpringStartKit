package com.naver.blog.point.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.naver.blog.point.service.PointChargeService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class TestPointChargeController {
	@Autowired PointChargeService pointChargeService;

	PointChargeController pointChargeController;
	
	@PostConstruct
	private void postConstuctor() {
		pointChargeController = new PointChargeController(pointChargeService);
	}
	
}
