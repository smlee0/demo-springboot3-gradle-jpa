package com.example.library.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.entity.Account;

/**
 * jpa AuditorAware 구현 클래스
 */
public class AuditorAwareImpl implements AuditorAware<Account> {
	@Override
	public Optional getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (null == authentication || !authentication.isAuthenticated()) {
			return Optional.empty();
		}

		//TODO 현재는 에러를 제거하기 위해 Account Entity를 직접 사용했지만, 성능 이슈가 발생하므로 JWT 진행 시 변경 필요
		Account account = (Account)authentication.getPrincipal();
		return Optional.of(account.getId());
		// return Optional.of(account.getAccountDto().getId());
	}
}
