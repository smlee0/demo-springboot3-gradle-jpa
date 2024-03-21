package com.example.library.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.entity.Account;
import com.example.module.api.v1.account.mapper.AccountMapper;

/**
 * JPA AuditorAware 구현부
 *
 * @author LEESEMIN
 */
public class AuditorAwareImpl implements AuditorAware<Account> {
	@Override
	public Optional getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null == authentication || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
			return Optional.empty();
		}
		Account account = (Account)authentication.getPrincipal();
		return Optional.of(AccountMapper.INSTANCE.toDto(account).getId());
		// 현재는 에러를 제거하기 위해 Account Entity를 직접 사용했었던 흔적 기록용으로 임시 보관
		// JWT 진행 시 캡슐화 작업을 위해 DTO로 변경 필요
		// return Optional.of(account.getId());
		// return Optional.of(((Account)authentication.getPrincipal()).getUsername());
	}
}
