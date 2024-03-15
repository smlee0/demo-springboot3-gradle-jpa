package com.example.library.security.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * JWT 토큰 생성 DTO
 *
 * @author LEESEMIN
 */
@Getter
@AllArgsConstructor
@Builder
@ToString
public class GeneratedToken {

	private String accessToken;
	private String refreshToken;
}