package com.example.library.security.jwt.util;

import java.util.Base64;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.library.constant.CommonConstant;
import com.example.library.security.jwt.dto.GeneratedToken;
import com.example.library.security.jwt.service.JwtTokenService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * JWT 유틸 클래스
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtUtil {

	private final JwtTokenService tokenService;
	private static final String JWT_SECRET_KEY = "b07427c04cd8b5647a3f1979509ee2847130e3434e1acb7e93a4650b71d5bd5485870d36c1584ab46e0527b2eb9d0f4998151a386d69b48e906457ffdeb41896";
	private String secretKey;

	/**
	 * 초기화
	 */
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(JWT_SECRET_KEY.getBytes());
	}

	/**
	 * JWT Token 일괄 발급
	 * @param email
	 * @param role
	 * @return
	 */
	public GeneratedToken generateToken(String email, String role) {
		// refreshToken과 accessToken을 생성한다.
		String refreshToken = generateRefreshToken(email, role);
		String accessToken = generateAccessToken(email, role);

		// 토큰을 Redis에 저장한다.
		tokenService.saveTokenInfo(email, refreshToken, accessToken);
		return new GeneratedToken(accessToken, refreshToken);
	}

	/**
	 * JWT Refresh Token 발급
	 * @param email
	 * @param role
	 * @return
	 */
	public String generateRefreshToken(String email, String role) {

		// 새로운 클레임 객체를 생성하고, 이메일과 역할(권한)을 셋팅
		Claims claims = Jwts.claims().setSubject(email);
		claims.put("role", role);

		// 현재 시간과 날짜를 가져온다.
		Date now = new Date();

		return Jwts.builder()
			// Payload를 구성하는 속성들을 정의한다.
			.setClaims(claims)
			// 발행일자를 넣는다.
			.setIssuedAt(now)
			// 토큰의 만료일시를 설정한다.
			.setExpiration(new Date(System.currentTimeMillis() + CommonConstant.JWT_REFRESH_TOKEN_VALIDITY * 1000))
			// 지정된 서명 알고리즘과 비밀 키를 사용하여 토큰을 서명한다.
			.signWith(SignatureAlgorithm.HS256, secretKey)
			.compact();
	}

	/**
	 * JWT Access Token 발급
	 * @param email
	 * @param role
	 * @return
	 */
	public String generateAccessToken(String email, String role) {

		Claims claims = Jwts.claims().setSubject(email);
		claims.put("role", role);

		Date now = new Date();
		return
			Jwts.builder()
				// Payload를 구성하는 속성들을 정의한다.
				.setClaims(claims)
				// 발행일자를 넣는다.
				.setIssuedAt(now)
				// 토큰의 만료일시를 설정한다.
				.setExpiration(new Date(System.currentTimeMillis() + CommonConstant.JWT_ACCESS_TOKEN_VALIDITY * 1000))
				// 지정된 서명 알고리즘과 비밀 키를 사용하여 토큰을 서명한다.
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();

	}

	/**
	 * JWT Token 검증
	 * @param token
	 * @return
	 */
	public boolean verifyToken(String token) {
		try {
			Jws<Claims> claims = Jwts.parser()
				.setSigningKey(secretKey) // 비밀키를 설정하여 파싱한다.
				.parseClaimsJws(token);  // 주어진 토큰을 파싱하여 Claims 객체를 얻는다.
			// 토큰의 만료 시간과 현재 시간비교
			return claims.getBody()
				.getExpiration()
				.after(new Date());  // 만료 시간이 현재 시간 이후인지 확인하여 유효성 검사 결과를 반환
		} catch (Exception e) {
			log.info("[JWT] 토큰 만료: {}", token);
			return false;
		}
	}

	/**
	 * 토큰에서 Email 추출
	 * @param token
	 * @return
	 */
	public String getUid(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * 토큰에서 ROLE(권한) 추출
	 * @param token
	 * @return
	 */
	public String getRole(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("role", String.class);
	}

}