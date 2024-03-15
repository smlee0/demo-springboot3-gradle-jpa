package com.example.library.security.jwt.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.library.security.jwt.dto.JwtToken;

@Repository
public interface JwtTokenRepository extends CrudRepository<JwtToken, String> {

	// accessToken으로 RefreshToken을 찾아온다.
	Optional<JwtToken> findByAccessToken(String accessToken);
}