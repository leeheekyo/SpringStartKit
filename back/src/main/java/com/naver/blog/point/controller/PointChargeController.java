package com.naver.blog.point.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.naver.blog.point.service.PointChargeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/point/charge")
@RestController
@RequiredArgsConstructor
@Slf4j
public class PointChargeController {
	private final PointChargeService pointChargeService;
	@GetMapping("/sample")
	public Object sample(
			) {
		
		return pointChargeService.sampleData();
	}
	
}
