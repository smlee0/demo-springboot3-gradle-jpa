package com.example.module.api.v1.account.service;

import java.util.Optional;

import com.example.module.api.v1.account.dto.response.AccountResponseDto;

/**
 * 계정 서비스
 *
 * @author LEESEMIN
 */
public interface AccountService {

	/**
	 * 계정 정보 조회 (이메일)
	 *
	 * @param email
	 * @return 단일 계정 정보
	 */
	Optional<AccountResponseDto> findByEmail(String email);
}
