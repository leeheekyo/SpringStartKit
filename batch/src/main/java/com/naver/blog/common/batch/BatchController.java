package com.naver.blog.common.batch;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.batch.BasicBatchConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.naver.blog.common.job.AlarmSendJob;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/point/charge")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BatchController {
	@Autowired //@Qualifier("alarmSendJob")
    private AlarmSendJob job;
    private final JobLauncher jobLauncher;
//    private final SpringBatchConfig batchConfigurer;

    @PostMapping("/batch")
    public String launch(@RequestBody BatchVo batchVo) throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
//    	applicationContext.scan("com.blog.naver");
//    	applicationContext.refresh();
//    	Job job = applicationContext.getBean(AlarmSendJob.class);
    	
//    	JobLauncher jobLauncher = batchConfigurer.getJobLauncher();
    	
        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("date", new Date())
                .toJobParameters();

        log.info(job.getName());
        /* batch 수행 */
        jobLauncher.run(job, jobParameters);

        return "batch completed";
    }
	
}
