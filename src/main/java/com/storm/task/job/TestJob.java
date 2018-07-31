package com.storm.task.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.storm.util.LoggingUtil;

public class TestJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		LoggingUtil.info("TestJob : ", "###################################");
	}

}
