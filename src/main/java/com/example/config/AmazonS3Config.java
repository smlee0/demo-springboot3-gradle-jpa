package com.example.config;

import org.springframework.beans.factory.annotation.Value;
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
import com.example.library.util.PropertiesUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * AWS S3 설정 클래스
 *
 * @author LEESEMIN
 */
@Slf4j
@Configuration
public class AmazonS3Config {

	// @Value("${cloud.aws.credentials.access-key}")
	// private String accessKey;
	//
	// @Value("${cloud.aws.credentials.secret-key}")
	// private String secretKey;

	// @Value("${cloud.role.arn}")
	// private String roleARN;
	//
	// @Value("${cloud.role.session.name}")
	// private String roleSessionName;
	//
	// @Value("${cloud.credentials.profile}")
	// private String credentialsProfile;
	//
	@Value("${cloud.aws.region.static}")
	private String region;

	@Bean
	public AmazonS3Client amazonS3Client() {
		log.info("[Bean] amazonS3");
		String profile = System.getProperty("spring.profiles.active");

		// 로컬 개발 환경 설정
		if (!profile.equals(ProfileType.LOCAL.toString())) {
			String roleARN = PropertiesUtil.get("cloud.role.arn");
			String roleSessionName = PropertiesUtil.get("cloud.role.session.name");
			String credentialsProfile = PropertiesUtil.get("cloud.credentials.profile");

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