package com.naver.blog.common.job;

import java.math.BigInteger;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersIncrementer;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import com.naver.blog.config.CustomJobParametersIncrementer;
import com.naver.blog.config.CustomJobParametersValidator;
import com.naver.blog.point.dao.PointChargeDao;
import com.naver.blog.util.RequestUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class AlarmSendJob implements Job {
	private final CustomJobParametersValidator jobParametersValidator;
	private final CustomJobParametersIncrementer jobParametersIncrementer;
	
	private final PointChargeDao pointChargeDao;
	
	@Value("${url.back}")
	private String baseBackUrl; 

	@Override
	public String getName() {
		return "AlarmSendJob";
	}

	@Override
	public boolean isRestartable() {
		return false;
	}

	@Override
	public void execute(JobExecution execution) {
		log.info(getName() + " execution call!");
		// read Item
		BigInteger targetCount = pointChargeDao.selectSampleData();
		
	}

	@Override
	public JobParametersIncrementer getJobParametersIncrementer() {
		return jobParametersIncrementer;
	}

	@Override
	public JobParametersValidator getJobParametersValidator() {
		return jobParametersValidator;
	}
	
}
