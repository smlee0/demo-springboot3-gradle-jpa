// package com.example.library.common;
//
// import java.util.Collection;
// import java.util.LinkedHashMap;
//
// import org.springframework.core.Conventions;
//
// import lombok.AccessLevel;
// import lombok.AllArgsConstructor;
// import lombok.Getter;
// import lombok.Setter;
//
// /**
//  * JSON 공통 응답
//  *
//  * @author LEESEMIN
//  *
//  */
// @AllArgsConstructor(access = AccessLevel.PRIVATE)
// @Getter
// @Setter
// //@JsonInclude(JsonInclude.Include.NON_EMPTY)
// public class CommonResponse {
// 	/**
// 	 * 결과 코드
// 	 */
// 	private String resultCode;
// 	/**
// 	 * 결과 메세지
// 	 */
// 	private String resultMsg;
// 	/**
// 	 * 리다이렉트 URL
// 	 */
// 	private String redirectUrl;
// 	/**
// 	 * 데이터
// 	 */
// 	private LinkedHashMap<String, Object> data;
//
// 	/**
// 	 * 빌더 메소드
// 	 *
// 	 * @return CommonResponseBuilder
// 	 */
// 	public static CommonResponseBuilder builder() {
// 		return new CommonResponseBuilder();
// 	}
//
// 	public static class CommonResponseBuilder {
// 		private String resultCode = "000";
// 		private String resultMsg = "성공";
// 		private String redirectUrl;
// 		private LinkedHashMap<String, Object> data = new LinkedHashMap<>();
//
// 		public CommonResponseBuilder resultCode(String resultCode) {
// 			this.resultCode = resultCode;
// 			return this;
// 		}
//
// 		public CommonResponseBuilder resultMsg(String resultMsg) {
// 			this.resultMsg = resultMsg;
// 			return this;
// 		}
//
// 		public CommonResponseBuilder redirectUrl(String redirectUrl) {
// 			this.redirectUrl = redirectUrl;
// 			return this;
// 		}
//
// 		public CommonResponseBuilder data(Object object) {
// 			if (object != null) {
// 				// 빈 값 처리
// 				if (object instanceof Collection && ((Collection<?>)object).isEmpty()) {
// 					return this;
// 				} else {
// 					data.put(Conventions.getVariableName(object), object);
// 				}
// 			}
// 			return this;
// 		}
//
// 		public CommonResponseBuilder data(String name, Object object) {
// 			data.put(name, object);
// 			return this;
// 		}
//
// 		public CommonResponse build() {
// 			return new CommonResponse(resultCode, resultMsg, redirectUrl, data);
// 		}
// 	}
// }
