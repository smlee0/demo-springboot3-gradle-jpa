package com.example.library.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 로그인이 되어 있으나 권한이 충분하지 않을 때 안내 처리
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException,
		ServletException {
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		response.setStatus(403);

		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", "403");
		resultMap.put("message", "권한이 없습니다.");

		ObjectMapper obm = new ObjectMapper();
		String data = obm.writeValueAsString(resultMap);

		PrintWriter out = response.getWriter();
		out.print(data);
		out.flush();
		out.close();
	}
}