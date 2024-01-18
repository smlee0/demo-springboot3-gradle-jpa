package com.example.library.util;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * API 수행 결과 값 리턴
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Null 값인 필드 제외
public class Result<T> {
	/**
	 * 결과 코드
	 */
	private String code;
	/**
	 * 결과 메시지
	 */
	private String message;
	/**
	 * 결과 데이터
	 */
	private T data;

}