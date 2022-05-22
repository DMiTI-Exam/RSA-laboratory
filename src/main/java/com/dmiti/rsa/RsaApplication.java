package com.dmiti.rsa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
public class RsaApplication {
	@Bean
	public ThreadPoolTaskExecutor executorService() {
		ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
		taskExecutor.setCorePoolSize(5);
		taskExecutor.setMaxPoolSize(10);
		taskExecutor.setQueueCapacity(30);

		return taskExecutor;
	}

	public static void main(String[] args) {
		SpringApplication.run(RsaApplication.class, args);
	}
}
