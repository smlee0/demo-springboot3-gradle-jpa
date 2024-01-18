package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.entity.Account;
import com.example.library.security.AuditorAwareImpl;

/**
 * JPA 감시 설정
 * 자동 생성/수정(날짜/사용자) 매핑 후 생성
 * 사용법 : 엔티티에 @EntityListeners(AuditingEntityListener.class) 추가
 *
 * @author LEESEMIN
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {
	@Bean
	public AuditorAware<Account> auditorProvider() {
		return new AuditorAwareImpl();
	}
}