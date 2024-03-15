package com.example.library.security.jwt.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.library.exception.JwtException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtExceptionFilter extends OncePerRequestFilter {

	private final ObjectMapper objectMapper;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
		ServletException, IOException {
		try {
			filterChain.doFilter(request, response);
		} catch (JwtException e) {
			response.setContentType(MediaType.APPLICATION_JSON_VALUE);
			response.setCharacterEncoding(StandardCharsets.UTF_8.name());
			response.setStatus(HttpStatus.UNAUTHORIZED.value());

			Map<String, Object> resultMap = new HashMap<>();
			resultMap.put("status", HttpStatus.FORBIDDEN);
			resultMap.put("message", "권한이 없습니다.");

			ObjectMapper obm = new ObjectMapper();
			String data = obm.writeValueAsString(resultMap);

			PrintWriter out = response.getWriter();
			out.print(data);
			out.flush();
			out.close();
		}
	}
}