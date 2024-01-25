package com.example.library.security;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.entity.Account;

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

		//TODO 현재는 에러를 제거하기 위해 Account Entity를 직접 사용했지만, JWT 진행 시 캡슐화 작업을 위해 DTO로 변경 필요
		Account account = (Account)authentication.getPrincipal();
		return Optional.of(account.getId());
		// return Optional.of(account.getAccountDto().getId());
		// return Optional.of(((Account)authentication.getPrincipal()).getUsername());
	}
}
