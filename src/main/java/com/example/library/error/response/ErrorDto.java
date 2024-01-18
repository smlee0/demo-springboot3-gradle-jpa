package com.example.library.error.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * errorDto 에러 메시지 필드
 *
 * @author LEESEMIN
 */
@RequiredArgsConstructor
@Getter
@Setter
public class ErrorDto {

	private final String code;

	private final String message;
}
