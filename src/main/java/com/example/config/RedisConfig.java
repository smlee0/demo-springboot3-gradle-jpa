package com.example.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.example.library.util.PropertyUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Redis 설정 클래스
 *
 * @author LEESEMIN
 */
@Slf4j
@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisConfig {
	/**
	 * 프로퍼티 유틸
	 */
	private final PropertyUtil propertyUtil;

	/**
	 * Redis 연결 정보
	 *
	 * @return Redis Connection Factory
	 */
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
		redisStandaloneConfiguration.setHostName(propertyUtil.get("cloud.redis.host"));
		redisStandaloneConfiguration.setPort(Integer.parseInt(propertyUtil.get("cloud.redis.port")));
		redisStandaloneConfiguration.setPassword(propertyUtil.get("cloud.redis.password"));
		return new LettuceConnectionFactory(redisStandaloneConfiguration);
	}

	/**
	 * cache 설정
	 *
	 * @return CacheManager
	 */
	@Bean
	public CacheManager cacheManager() {
		RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
			.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()))
			.entryTtl(Duration.ofDays(1));

		return RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory()).cacheDefaults(configuration).build();
	}

	/**
	 * Redis 템플릿
	 *
	 * @return RedisTemplate
	 */
	@Bean
	public RedisTemplate<?, ?> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		return redisTemplate;
	}
}