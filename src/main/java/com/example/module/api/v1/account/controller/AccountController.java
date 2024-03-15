package com.example.module.api.v1.account.controller;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.security.jwt.dto.JwtToken;
import com.example.library.security.jwt.repository.JwtTokenRepository;
import com.example.library.security.jwt.service.JwtTokenService;
import com.example.library.security.jwt.util.JwtUtil;
import com.example.module.api.v1.account.dto.request.AccountRequestDto;
import com.example.module.api.v1.account.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 계정 컨트롤러
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class AccountController {
	/**
	 * 계정 서비스
	 */
	private final AccountService accountService;

	private final JwtTokenRepository jwtTokenRepository;
	private final JwtTokenService tokenService;
	private final JwtUtil jwtUtil;

	/**
	 * 계정 > 일반 로그인
	 *
	 * @return 로그인 성공 여부
	 */
	@GetMapping("/api/v1/account/login")
	public ResponseEntity<?> login() {
		return ResponseEntity.ok().body("");
	}

	/**
	 * 계정 > 일반 계정 회원가입
	 *
	 * @return 회원가입 성공 여부
	 */
	@PostMapping("/api/v1/account/join")
	public ResponseEntity<?> join() {
		return ResponseEntity.ok().body("");
	}

	/**
	 * 계정 > 리프레시 토큰 재발급
	 *
	 * @return 회원가입 성공 여부
	 */
	@PostMapping("/api/v1/account/refresh")
	public ResponseEntity<?> refresh(@RequestHeader("Authorization") final String accessToken) {

		// 액세스 토큰으로 Refresh 토큰 객체를 조회
		Optional<JwtToken> jwtToken = jwtTokenRepository.findByAccessToken(accessToken);

		// RefreshToken이 존재하고 유효하다면 실행
		if (jwtToken.isPresent() && jwtUtil.verifyToken(jwtToken.get().getRefreshToken())) {
			// RefreshToken 객체를 꺼내온다.
			JwtToken resultToken = jwtToken.get();
			// 권한과 아이디를 추출해 새로운 액세스토큰을 만든다.
			String newAccessToken = jwtUtil.generateAccessToken(resultToken.getId(), jwtUtil.getRole(resultToken.getRefreshToken()));
			// 액세스 토큰의 값을 수정해준다.
			resultToken.updateAccessToken(newAccessToken);
			jwtTokenRepository.save(resultToken);
			// 새로운 액세스 토큰을 반환해준다.
			return ResponseEntity.ok().body(newAccessToken);
		}

		return ResponseEntity.badRequest().body("");
	}

	/**
	 * 계정 > 로그아웃
	 *
	 * @return 로그아웃 성공 여부
	 */
	@PostMapping("/api/v1/account/logout")
	public ResponseEntity<?> logout(@RequestHeader("Authorization") final String accessToken) {
		// 엑세스 토큰으로 현재 Redis 정보 삭제
		tokenService.removeRefreshToken(accessToken);
		return ResponseEntity.ok().body("");
	}

	/**
	 * 계정 > 마이페이지
	 *
	 * @return 마이페이지 데이터 목록 리턴
	 */
	@GetMapping("/api/v1/account/my-page")
	public ResponseEntity<?> myPage(AccountRequestDto requestDto) {
		return ResponseEntity.ok().body("");
	}
}
