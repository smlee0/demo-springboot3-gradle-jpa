package com.example;

import java.util.TimeZone;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.example.library.constant.ProfileType;

import jakarta.annotation.PostConstruct;

/**
 * SpringBoot 애플리케이션 실행 클래스
 *
 * @author LEESEMIN
 */
@SpringBootApplication
public class DemoApplication {

	/**
	 * 실행 메인
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication application = new SpringApplicationBuilder()
			.sources(DemoApplication.class)
			.build();

		setDefaultProfile(application);
		application.run(args);

	}

	/**
	 * spring default profile setting - if null
	 * @param application
	 */
	public static void setDefaultProfile(SpringApplication application) {
		String profile = System.getProperty("spring.profiles.active");
		if (StringUtils.isEmpty(profile)) {
			application.setAdditionalProfiles(ProfileType.LOCAL.toString());
		}
	}

	/**
	 * 타임 존 설정
	 */
	@PostConstruct
	public void postConstruct() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}

}
