package com.example.library.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
	/**
	 * 결과 코드
	 */
	private String code;
	/**
	 * 결과 메시지
	 */
	private String message;

}