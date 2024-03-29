package com.example.config;

import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.library.security.CustomAccessDeniedHandler;
import com.example.library.security.CustomAuthenticationEntryPoint;
import com.example.library.security.MyAuthenticationFailureHandler;
import com.example.library.security.MyAuthenticationSuccessHandler;
import com.example.library.security.jwt.filter.JwtAuthFilter;
import com.example.library.security.jwt.filter.JwtExceptionFilter;
import com.example.library.security.oauth2.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;

/**
 * Spring Security 설정
 *
 * @author LEESEMIN
 */
@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	private final CustomOAuth2UserService customOAuth2UserService;
	private final MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
	private final MyAuthenticationFailureHandler myAuthenticationFailureHandler;
	private final JwtAuthFilter jwtAuthFilter;
	private final JwtExceptionFilter jwtExceptionFilter;

	/**
	 * 인증 없이 접근 허용할 정적 리소스 경로
	 */
	private static final String[] PERMIT_STATIC_PATH = {
		"/css/**",
		"/js/**",
		"/img/**",
		"/favicon.*"
	};

	/**
	 * 인증 없이 접근 허용할 URL 경로
	 */
	private static final String[] PERMIT_URL_PATH = {
		"/",
		"/h2-console/**",
		"/api/v1/account/join",
		"/api/v1/account/login/**",
		"/api/v1/account/refresh",
		"/api/v1/account/logout"
	};

	/**
	 * PasswordEncoder Bean 설정
	 *
	 * @return BCryptPasswordEncoder 객체
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * 시큐리티 필터 체인
	 * Springboot3.x 이상 버전 : 체이닝 -> 람다식 방식으로 변경
	 *
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			// csrf 비활성화 -> cookie를 사용하지 않으면 꺼도 된다. (cookie를 사용할 경우 httpOnly(XSS 방어), sameSite(CSRF 방어)로 방어해야 한다.)
			.csrf(AbstractHttpConfigurer::disable)
			// cors 비활성화 -> 프론트와 연결 시 따로 설정 필요
			.cors(AbstractHttpConfigurer::disable)
			// 기본 인증 로그인 비활성화
			.httpBasic(AbstractHttpConfigurer::disable)
			// 기본 login form 비활성화
			.formLogin(AbstractHttpConfigurer::disable)
			// 기본 logout 비활성화
			.logout(AbstractHttpConfigurer::disable)

			// 헤더 설정
			.headers(configurer -> configurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))

			// 세션 설정 (사용 안함)
			.sessionManagement(configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

			// 접근 권한 설정
			.authorizeHttpRequests(request -> request
				.requestMatchers(
					Stream
						.of(PERMIT_STATIC_PATH)
						.map(AntPathRequestMatcher::antMatcher)
						.toArray(AntPathRequestMatcher[]::new)
				).permitAll()
				.requestMatchers(
					Stream
						.of(PERMIT_URL_PATH)
						.map(AntPathRequestMatcher::antMatcher)
						.toArray(AntPathRequestMatcher[]::new)
				).permitAll()
				.anyRequest().authenticated()
			)

			// OAuth2 설정
			// OAuth2 로그인 기능에 대한 여러 설정의 진입점
			// OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
			.oauth2Login(oauth2 -> oauth2
				.authorizationEndpoint(authorization -> authorization.baseUri("/api/v1/account/login/oauth2")) // OAuth2 로그인 URL
				.redirectionEndpoint(redirect -> redirect.baseUri("/api/v1/account/oauth2/callback/*")) // OAuth2 리다이렉트 URL
				.userInfoEndpoint(c -> c.userService(customOAuth2UserService)) // OAuth2 회원정보 가공 처리
				.successHandler(myAuthenticationSuccessHandler) // 로그인 성공 시 핸들러
				.failureHandler(myAuthenticationFailureHandler) // 로그인 실패 시 핸들러
			)

			// 인증 예외 핸들링
			.exceptionHandling(exceptions -> exceptions
				.authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 401 예외 처리 (인증)
				.accessDeniedHandler(new CustomAccessDeniedHandler())) // 403 예외 처리 (인가)
		// .apply(new JwtConfigurerAdapter(tokenProvider))

		;

		return http
			.addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class) // CORS 필터 설정
			.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class) // JWT 관련 설정
			.addFilterBefore(jwtExceptionFilter, JwtAuthFilter.class) // 토큰 예외 핸들링
			// .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
			// .addFilterBefore(new TokenExceptionFilter(), tokenAuthenticationFilter.getClass())
			.build();
	}

	// cors filter
	private CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");

		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}