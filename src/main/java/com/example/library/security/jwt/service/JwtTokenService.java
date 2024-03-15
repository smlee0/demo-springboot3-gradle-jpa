package com.example.library.security.jwt.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.library.security.jwt.dto.JwtToken;
import com.example.library.security.jwt.repository.JwtTokenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

	private final JwtTokenRepository refreshTokenRepository;

	@Transactional
	public void saveTokenInfo(String email, String refreshToken, String accessToken) {
		refreshTokenRepository.save(new JwtToken(email, accessToken, refreshToken));
	}

	@Transactional
	public void removeRefreshToken(String accessToken) {
		JwtToken token = refreshTokenRepository.findByAccessToken(accessToken)
			.orElseThrow(IllegalArgumentException::new);

		refreshTokenRepository.delete(token);
	}
}