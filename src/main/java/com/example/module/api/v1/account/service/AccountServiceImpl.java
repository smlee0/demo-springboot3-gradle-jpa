package com.example.module.api.v1.account.service;

import java.util.Optional;

import com.example.library.annotation.TransactionalService;
import com.example.module.api.v1.account.dto.response.AccountResponseDto;
import com.example.module.api.v1.account.mapper.AccountMapper;
import com.example.module.api.v1.account.repository.AccountRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 계정 서비스 구현부
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@TransactionalService
public class AccountServiceImpl implements AccountService {

	/**
	 * 계정 레포지토리
	 */
	private final AccountRepository accountRepository;

	/**
	 * 계정 정보 조회 (이메일)
	 *
	 * @param email
	 * @return 단일 계정 정보
	 */
	@Override
	public Optional<AccountResponseDto> findByEmail(String email) {
		return Optional.ofNullable(AccountMapper.INSTANCE.toDto(accountRepository.findByEmail(email)));
	}

}
