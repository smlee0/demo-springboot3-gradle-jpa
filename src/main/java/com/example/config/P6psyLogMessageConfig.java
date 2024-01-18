package com.example.config;

import org.springframework.context.annotation.Configuration;

import com.example.library.formatter.P6spySqlFormatter;
import com.p6spy.engine.spy.P6SpyOptions;

import jakarta.annotation.PostConstruct;

/**
 * P6spy 포맷 설정
 *
 * @author LEESEMIN
 */
// @Profile("local")
@Configuration//(proxyBeanMethods = false)
class P6psyLogMessageConfig {

	@PostConstruct
	public void setLogMessageFormat() {
		P6SpyOptions.getActiveInstance().setLogMessageFormat(P6spySqlFormatter.class.getName());
	}
}
