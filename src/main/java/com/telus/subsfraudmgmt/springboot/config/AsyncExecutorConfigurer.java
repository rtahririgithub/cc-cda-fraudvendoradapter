package com.telus.subsfraudmgmt.springboot.config;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import com.telus.subsfraudmgmt.springboot.config.Config;
import com.telus.subsfraudmgmt.springboot.config.Config.TeluspubInvocationExecutorConfig;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;

import java.util.concurrent.Executor;

@Component
@EnableAsync
public class AsyncExecutorConfigurer {
	private static final Log LOG = CustomizedLogFactory.getLog(AsyncExecutorConfigurer.class.getName());
	
	@Autowired
	private Config config;
	
	@Bean(name = "teluspubTaskExecutor")
	public Executor taskExecutor() {

		LOG.info("Creating Async telus pub invocation Task Executor");
		TeluspubInvocationExecutorConfig executorConfig = config.getTeluspubInvocationExecutorConfig();
		LOG.info(GeneralUtil.recusiveToString(executorConfig));
		final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(executorConfig.getCorePoolSize());
		executor.setMaxPoolSize(executorConfig.getMaxPoolSize());
		executor.setQueueCapacity(executorConfig.getQueueCapacity());
		executor.setThreadNamePrefix("TelusPubInvocationThread-");
		executor.initialize();

		return executor;

	}
}
