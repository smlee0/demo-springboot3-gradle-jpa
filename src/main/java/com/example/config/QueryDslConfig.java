package com.example.config;

import org.springframework.context.annotation.Configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * query dsl config
 */
@Configuration
public class QueryDslConfig {
	@PersistenceContext
	private EntityManager entityManager;

	// @Bean
	// public JPAQueryFactory jpaQueryFactory() {
	// 	return new JPAQueryFactory(entityManager);
	// }
}
