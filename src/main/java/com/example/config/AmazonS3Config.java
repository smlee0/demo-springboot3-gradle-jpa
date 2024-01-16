package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicSessionCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazonaws.services.securitytoken.model.Credentials;
import com.example.library.constant.ProfileType;
import com.example.library.util.PropertyUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * AWS S3 설정 클래스
 *
 * @author LEESEMIN
 */
@Slf4j
@Configuration
@RequiredArgsConstructor
public class AmazonS3Config {
	/**
	 * 프로퍼티 유틸
	 */
	private final PropertyUtil propertyUtil;

	@Bean
	public AmazonS3Client amazonS3Client() {
		log.info("[Bean] amazonS3");
		String profile = System.getProperty("spring.profiles.active");
		String roleARN = propertyUtil.get("cloud.role.arn");
		String roleSessionName = propertyUtil.get("cloud.role.session.name");
		String credentialsProfile = propertyUtil.get("cloud.credentials.profile");
		String region = propertyUtil.get("cloud.aws.region.static");

		// 로컬 개발 환경 설정
		if (!profile.equals(ProfileType.LOCAL.toString())) {
			AWSSecurityTokenService stsClient = AWSSecurityTokenServiceClientBuilder.standard()
				.withCredentials(new ProfileCredentialsProvider(credentialsProfile)).withRegion(region).build();

			AssumeRoleRequest roleRequest = new AssumeRoleRequest().withRoleArn(roleARN).withRoleSessionName(roleSessionName)
				.withDurationSeconds(3600);
			AssumeRoleResult roleResponse = stsClient.assumeRole(roleRequest);
			Credentials sessionCredentials = roleResponse.getCredentials();

			BasicSessionCredentials awsCredentials = new BasicSessionCredentials(sessionCredentials.getAccessKeyId(),
				sessionCredentials.getSecretAccessKey(), sessionCredentials.getSessionToken());

			return (AmazonS3Client)AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.withRegion(region).build();
		} else {
			return (AmazonS3Client)AmazonS3ClientBuilder.standard().withRegion(region).build();
		}
	}
}