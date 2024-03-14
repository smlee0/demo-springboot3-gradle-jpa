package com.example.library.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 로그인이 이루어지지 않거나 유효하지 않은 토큰으로 접근 시 안내 처리 (Unauthorized)
 *
 * @author LEESEMIN
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException {
		response.setContentType(MediaType.APPLICATION_JSON_VALUE);
		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setStatus(HttpStatus.UNAUTHORIZED.value());

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", HttpStatus.UNAUTHORIZED);
		resultMap.put("message", "로그인이 필요한 서비스 입니다.");

		ObjectMapper obm = new ObjectMapper();
		String data = obm.writeValueAsString(resultMap);

		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}
}