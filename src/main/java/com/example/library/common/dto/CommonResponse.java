package com.example.library.common.dto;

import java.util.Collection;
import java.util.LinkedHashMap;

import org.springframework.core.Conventions;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * API 공통 응답
 *
 * @author LEESEMIN
 *
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CommonResponse {
	/**
	 * 결과 코드
	 */
	private String code;
	/**
	 * 결과 메세지
	 */
	private String message;
	/**
	 * 리다이렉트 URL
	 */
	private String redirectUrl;
	/**
	 * 데이터
	 */
	private LinkedHashMap<String, Object> data;

	/**
	 * 빌더 메소드
	 *
	 * @return CommonResponseBuilder
	 */
	public static CommonResponseBuilder builder() {
		return new CommonResponseBuilder();
	}

	public static class CommonResponseBuilder {
		private String code = "200";
		private String message;
		private String redirectUrl;
		private LinkedHashMap<String, Object> data = new LinkedHashMap<>();

		public CommonResponseBuilder code(String code) {
			this.code = code;
			return this;
		}

		public CommonResponseBuilder message(String message) {
			this.message = message;
			return this;
		}

		public CommonResponseBuilder redirectUrl(String redirectUrl) {
			this.redirectUrl = redirectUrl;
			return this;
		}

		public CommonResponseBuilder data(Object object) {
			if (object != null) {
				// 빈 값 처리
				if (object instanceof Collection && ((Collection<?>)object).isEmpty()) {
					return this;
				} else {
					data.put(Conventions.getVariableName(object), object);
				}
			}
			return this;
		}

		public CommonResponseBuilder data(String name, Object object) {
			data.put(name, object);
			return this;
		}

		public CommonResponse build() {
			return new CommonResponse(code, message, redirectUrl, data);
		}
	}
}
