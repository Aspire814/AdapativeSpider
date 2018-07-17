package com.storm.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.storm.App;
import com.storm.mapper.TaskInfoMapper;
import com.storm.mapper.TaskTriggerMapper;
import com.storm.model.TaskInfo;
import com.storm.model.TaskTrigger;
import com.storm.util.LoggingUtil;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@Transactional
public class ScheduleTriggerServiceTest {
	@Autowired
	private Scheduler scheduler;

	@Autowired
	private TaskInfoMapper taskInfoMapper;
	
	@Autowired
	private TaskTriggerMapper taskTriggerMapper;
	
	@Test
	public void TestTask() throws Exception{
		if(scheduler != null) {
			LoggingUtil.error("Test Message", "refreshTrigger!!");
			TaskInfo taskInfo = taskInfoMapper.selectByPrimaryKey(1L);
			TaskTrigger taskTrigger = taskTriggerMapper.selectByPrimaryKey(1L);
			if(taskInfo != null && taskTrigger != null) {
				String beanClass = taskInfo.getBeanclass();
				String jobName = taskInfo.getJobname();
				String groupName = taskInfo.getJobgroup();
				String cronExpression = taskTrigger.getCronExpression();
				String triggerName = taskTrigger.getTriggerName();
				String triggerGroup = taskTrigger.getTriggerGroup();
				Class clazz;
				try {
					clazz = Class.forName(beanClass);
					JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(jobName, groupName).build();
			        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);
			        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup)
			                .withSchedule(scheduleBuilder).build();
			        scheduler.scheduleJob(jobDetail, cronTrigger);
			        Thread.sleep(Long.MAX_VALUE);
				} catch (ClassNotFoundException e) {
					LoggingUtil.error("ScheduleTriggerServiceTest Error:", beanClass + " not found!");
					e.printStackTrace();
					throw e;
				} catch (SchedulerException e) {
					LoggingUtil.error("ScheduleTriggerServiceTest Error:","scheduler 调度出错！");
					e.printStackTrace();
					throw e;
				} catch (InterruptedException e) {
					LoggingUtil.error("ScheduleTriggerServiceTest Error:","线程中断异常！");
					e.printStackTrace();
					throw e;
				}
			}
		}
	}
}