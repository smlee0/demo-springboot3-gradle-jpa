package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.RequiredArgsConstructor;

/**
 * Spring Security 설정
 *
 * @author LEESEMIN
 */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

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
			// 로그인 폼 설정 (사용 안함)
			.formLogin((formLoginConfig) ->
				formLoginConfig.disable()
			)

			// csrf 설정 (사용 안함)
			.csrf((csrfConfig) ->
				csrfConfig.disable()
			)

			// 헤더 설정
			.headers((headerConfig) ->
				headerConfig.frameOptions(frameOptionsConfig ->
					frameOptionsConfig.sameOrigin()
				)
			)

			// 세션 설정 (사용 안함)
			.sessionManagement((sessionManagementConfig) ->
				sessionManagementConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			)

			// 접근 권한 설정
			.authorizeHttpRequests((authorizeHttpRequestsConfig) ->
				authorizeHttpRequestsConfig
					// .requestMatchers(PathRequest.toH2Console()).permitAll()
					// .requestMatchers("/", "/login/**").permitAll()
					// .requestMatchers("/posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
					// .requestMatchers("/admins/**", "/api/v1/admins/**").hasRole(Role.ADMIN.name())
					// .anyRequest().authenticated()
					.anyRequest().permitAll()
			)

			// 필터 설정
			.addFilterBefore(corsFilter(), UsernamePasswordAuthenticationFilter.class)

		// 익셉션 핸들링 설정
		// .exceptionHandling((exceptionConfig) ->
		// 	exceptionConfig
		// 		.authenticationEntryPoint(new JwtAuthenticationEntryPoint())
		// 		.accessDeniedHandler(new JwtAccessDeniedHandler())
		// )
		// .apply(new JwtConfigurerAdapter(tokenProvider))

		;

		return http.build();
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