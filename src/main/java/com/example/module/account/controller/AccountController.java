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
	 * 일반 계정 로그인
	 *
	 * @return
	 */
	@GetMapping("/api/v1/login")
	public ResponseEntity<?> login(AccountRequestDto requestDto) {
		return ResponseEntity.ok().body("");
	}

	/**
	 * 일반 계정 회원가입
	 *
	 * @return
	 */
	@GetMapping("/api/v1/join")
	public ResponseEntity<?> join(AccountRequestDto requestDto) {
		return ResponseEntity.ok().body("");
	}

	/**
	 * 일반 계정 마이페이지
	 *
	 * @return
	 */
	@GetMapping("/api/v1/my-page")
	public ResponseEntity<?> myPage(AccountRequestDto requestDto) {
		return ResponseEntity.ok().body("");
	}
}
