package com.example.library.security.jwt;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccessTokenService {

	private final RefreshTokenRepository tokenRepository;

	@Transactional
	public void saveTokenInfo(String email, String refreshToken, String accessToken) {
		tokenRepository.save(new RefreshToken(email, accessToken, refreshToken));
	}
}