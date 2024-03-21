package com.example.library.security.jwt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.security.jwt.dto.JwtToken;
import com.example.library.security.jwt.repository.JwtTokenRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * JWT 토큰 서비스 (구현부 포함)
 *
 * @author LEESEMIN
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JwtTokenService {

	private final JwtTokenRepository jwtTokenRepository;

	@Transactional
	public void saveTokenInfo(String email, String accessToken, String refreshToken) {
		jwtTokenRepository.save(new JwtToken(email, accessToken, refreshToken));
	}

	@Transactional
	public void removeRefreshToken(String accessToken) {
		JwtToken token = jwtTokenRepository.findByAccessToken(accessToken)
			.orElseThrow(IllegalArgumentException::new);
		log.debug("token: {}", token);

		jwtTokenRepository.delete(token);
	}
}