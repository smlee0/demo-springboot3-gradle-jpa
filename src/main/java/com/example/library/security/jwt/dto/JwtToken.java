package com.example.library.security.jwt.dto;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import com.example.library.constant.CommonConstant;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * JWT 토큰 DTO
 *
 * @author LEESEMIN
 */
@Getter
@AllArgsConstructor
@RedisHash(value = "jwtToken", timeToLive = CommonConstant.JWT_REFRESH_TOKEN_VALIDITY)
// @RedisHash(value = "jwtToken", timeToLive = 10)
public class JwtToken implements Serializable {

	@Id
	private String id;

	@Indexed
	private String accessToken;

	private String refreshToken;

	public void updateAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

}