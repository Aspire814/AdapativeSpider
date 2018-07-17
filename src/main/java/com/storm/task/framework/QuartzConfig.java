package com.storm.task.framework;

import java.io.IOException;
import java.util.Properties;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.storm.util.LoggingUtil;

@Configuration
public class QuartzConfig {
	@Autowired
	private JobFactory jobFactory;

	// 获取工厂bean
	@Bean
	public SchedulerFactoryBean schedulerFactoryBean() {
		SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
		try {
			schedulerFactoryBean.setQuartzProperties(quartzProperties());
			schedulerFactoryBean.setJobFactory(jobFactory);
		} catch (IOException e) {
			LoggingUtil.error("com.storm.task.framework.QuartzConfig : ","Creating SchedulerFactoryBean failure!");
			e.printStackTrace();
		}
		return schedulerFactoryBean;
	}

	// 指定quartz.properties
	@Bean
	public Properties quartzProperties() throws IOException {
		PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
		propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
		propertiesFactoryBean.afterPropertiesSet();
		return propertiesFactoryBean.getObject();
	}

	// 创建schedule
	@Bean(name = "scheduler")
	public Scheduler scheduler() {
		return schedulerFactoryBean().getScheduler();
	}

}
