package com.example.library.constant;

/**
 * 공통 상수 관리 클래스
 *
 * @author LEESEMIN
 *
 */
public class CommonConstant {
	/**
	 * JWT AccessToken 유효시간 (30분)
	 */
	public static final long JWT_ACCESS_TOKEN_VALIDITY = 60L * 30L;
	/**
	 * JWT RefreshToken 유효시간 (30일)
	 */
	public static final long JWT_REFRESH_TOKEN_VALIDITY = 60L * 60L * 24L * 30L;
}
