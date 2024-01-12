package com.example.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

/**
 * 웹 기본 설정
 */
@Slf4j
@Configuration
public class WebConfig {

	/**
	 * ModelMapper Bean 등록
	 *
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		log.info("[Bean] ModelMapper");

		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration()
			.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
			.setFieldMatchingEnabled(true)
			.setMatchingStrategy(MatchingStrategies.STRICT);

		return modelMapper;
	}
}
