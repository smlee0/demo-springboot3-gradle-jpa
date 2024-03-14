package com.example.library.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 로그인이 이루어지지 않거나 유효하지 않은 토큰으로 접근 시 안내 처리
 */
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.setStatus(401);

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "401");
		resultMap.put("message", "로그인이 필요한 서비스 입니다.");

		ObjectMapper obm = new ObjectMapper();
		String data = obm.writeValueAsString(resultMap);

		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}
}