package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.entity.Account;
import com.example.library.security.AuditorAwareImpl;

/**
 * jpa auditing config
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {
	@Bean
	public AuditorAware<Account> auditorProvider() {
		return new AuditorAwareImpl();
	}
}