package com.example.library.security.jwt.filter;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.entity.Account;
import com.example.library.exception.JwtException;
import com.example.library.security.jwt.util.JwtUtil;
import com.example.module.api.v1.account.dto.response.AccountResponseDto;
import com.example.module.api.v1.account.mapper.AccountMapper;
import com.example.module.api.v1.account.repository.AccountRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;
	private final AccountRepository accountRepository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
		throws ServletException, IOException {
		// request Header에서 AccessToken을 가져온다.
		String atc = request.getHeader("Authorization");

		// 토큰 검사 생략(모두 허용 URL의 경우 토큰 검사 통과)
		if (!StringUtils.hasText(atc)) {
			doFilter(request, response, filterChain);
			return;
		}

		// AccessToken을 검증하고, 만료되었을경우 예외를 발생시킨다.
		if (!jwtUtil.verifyToken(atc)) {
			throw new JwtException("Access Token 만료!");
		}

		// AccessToken의 값이 있고, 유효한 경우에 진행한다.
		if (jwtUtil.verifyToken(atc)) {

			// AccessToken 내부의 payload에 있는 email로 user를 조회한다. 없다면 예외를 발생시킨다 -> 정상 케이스가 아님
			Account findAccount = accountRepository.findByEmail(jwtUtil.getUid(atc));
			// .orElseThrow(IllegalStateException::new);

			// SecurityContext에 등록할 User 객체를 만들어준다.
			// SecurityUserDto userDto = SecurityUserDto.builder()
			//         .id(findAccount.getId())
			//         .email(findAccount.getEmail())
			//         .accountRole("ROLE_".concat(findAccount.getAccountRole().name()))
			//         .nickname(findAccount.getNickname())
			//         .build();

			// SecurityContext에 인증 객체를 등록해준다.
			Authentication auth = getAuthentication(AccountMapper.INSTANCE.toDto(findAccount));
			SecurityContextHolder.getContext().setAuthentication(auth);
		}

		filterChain.doFilter(request, response);
	}

	public Authentication getAuthentication(AccountResponseDto responseDto) {
		return new UsernamePasswordAuthenticationToken(responseDto, "",
			List.of(new SimpleGrantedAuthority(responseDto.getAccountRole().name())));
	}

}