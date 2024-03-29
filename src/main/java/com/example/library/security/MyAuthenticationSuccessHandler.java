package com.example.library.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.library.security.jwt.dto.GeneratedToken;
import com.example.library.security.jwt.util.JwtUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 로그인 인증 실패 시 처리 핸들러
 *
 * @author LEESEMIN
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private final JwtUtil jwtUtil;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,
		ServletException {

		// OAuth2User로 캐스팅하여 인증된 사용자 정보
		OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
		// 사용자 이메일 정보
		String email = oAuth2User.getAttribute("email");
		// 서비스 제공 플랫폼(GOOGLE, KAKAO, NAVER) 확인
		String provider = oAuth2User.getAttribute("provider");

		// CustomOAuth2UserService에서 셋팅한 로그인한 회원 존재 여부 확인
		boolean isExist = oAuth2User.getAttribute("exist");
		// OAuth2User로 부터 Role 정보 확인
		String role = oAuth2User.getAuthorities().stream()
			.findFirst()
			.orElseThrow(IllegalAccessError::new)
			.getAuthority();
		log.info(">>> role: {}", role);

		oAuth2User.getAttributes().forEach((k, v) -> {
			log.info("{}: {}", k, v);
		});

		// 회원이 존재할경우
		if (isExist) {
			// 회원이 존재하면 jwt token 발행을 시작한다.
			GeneratedToken token = jwtUtil.generateToken(email, role);
			log.info("jwtToken = {}", token.getAccessToken());

			// accessToken을 쿼리스트링에 담는 url을 만들어준다.
			String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:3000/login/callback")
				.queryParam("accessToken", token.getAccessToken())
				.build()
				.encode(StandardCharsets.UTF_8)
				.toUriString();
			log.info("redirect 준비");
			// 로그인 확인 페이지로 리다이렉트 시킨다.
			getRedirectStrategy().sendRedirect(request, response, targetUrl);

		} else {

			// 회원이 존재하지 않을경우, 서비스 제공자와 email을 쿼리스트링으로 전달하는 url을 만들어준다.
			String targetUrl = UriComponentsBuilder.fromUriString("http://localhost:3000/login/callback")
				.queryParam("email", (String)oAuth2User.getAttribute("email"))
				.queryParam("provider", provider)
				.build()
				.encode(StandardCharsets.UTF_8)
				.toUriString();
			// 회원가입 페이지로 리다이렉트 시킨다.
			getRedirectStrategy().sendRedirect(request, response, targetUrl);
		}
	}

}