package com.iteriam.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.corp.calculator.TracerImpl;

@Configuration
public class BeansConfiguration {

	@Bean
	public TracerImpl tracerImpl() {
		return new TracerImpl();
	}
}