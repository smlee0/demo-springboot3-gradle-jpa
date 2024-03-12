package com.example.module.account.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.module.account.dto.request.AccountRequestDto;
import com.example.module.account.service.AccountService;

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

	/**
	 * 계정 > 일반 로그인
	 *
	 * @return
	 */
	@GetMapping("/api/v1/account/login")
	public ResponseEntity<?> login() {
		return ResponseEntity.ok().body("");
	}

	/**
	 * 계정 > 일반 계정 회원가입
	 *
	 * @return
	 */
	@GetMapping("/api/v1/account/join")
	public ResponseEntity<?> join() {
		return ResponseEntity.ok().body("");
	}

	/**
	 * 계정 > 로그아웃
	 *
	 * @return
	 */
	@GetMapping("/api/v1/account/logout")
	public ResponseEntity<?> logout() {
		return ResponseEntity.ok().body("");
	}

	/**
	 * 계정 > 마이페이지
	 *
	 * @return
	 */
	@GetMapping("/api/v1/account/my-page")
	public ResponseEntity<?> myPage(AccountRequestDto requestDto) {
		return ResponseEntity.ok().body("");
	}
}
